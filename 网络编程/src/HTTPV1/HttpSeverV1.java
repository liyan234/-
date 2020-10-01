package HTTPV1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpSeverV1 {
    private ServerSocket serverSocket = null;

    public HttpSeverV1 (int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        //创建一个线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        while (true) {
            Socket clientSocket = serverSocket.accept();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    processConnect(clientSocket);
                }
            });
        }
    }

    private void processConnect(Socket clientSocket) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {

            //1. 读取请求并解析
            String firstLine =  bufferedReader.readLine();//首行
            String[] firstLineTokens = firstLine.split(" ");

            String method = firstLineTokens[0];//方法
            String url = firstLineTokens[1];//url
            String version = firstLineTokens[2];//http协议的版本号

            Map<String, String> headers = new HashMap<>();//协议头
            String line = "";

            while ((line = bufferedReader.readLine()) != null && line.length() != 0) {
                String[] headerTokens = line.split(": ");
                headers.put(headerTokens[0], headerTokens[1]);
            }
            System.out.printf("%s %s %s\n", method, url, version);

            for (Map.Entry<String,String> entry : headers.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            System.out.println();
            //计算响应
            String rep = "";
            if (url.equals("/ok")) {
                bufferedWriter.write(version + " 200 OK\n");
                rep = "<h1>hello</h1>";
            } else if (url.equals("/notfound")) {
                bufferedWriter.write(version + " 404 Not Found\n");
                rep = "<h1>not found</h1>";
            } else if (url.equals("/seeother")) {
                bufferedWriter.write(version + " 303 See Other\n");
                bufferedWriter.write("Location: http://www.sogou.com\n");
                rep = "";//重定义
            } else {
                bufferedWriter.write(version + " 200 OK\n");
                rep = "<h1>default</h1>";
            }

            //把响应写回到客户端
            bufferedWriter.write("Content-Type: text/html\n");//首行(版本号，状态码，状态码的描述信息)
            bufferedWriter.write("Content-Length" + rep.getBytes().length + "\n");//(协议头)
            bufferedWriter.write("\n");//空行
            bufferedWriter.write(rep);//正文

            bufferedWriter.flush();//刷新
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

