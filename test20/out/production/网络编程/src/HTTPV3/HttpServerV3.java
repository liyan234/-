package HTTPV3;



import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServerV3 {

    static class User {
        public String userName;
        public int age;
        public String school;
    }
    
    private ServerSocket serverSocket = null;

    //session会话， 指的就是同一个用户的一组访问服务器的操作，归类到一起
    //session中有很多的会话，会话指的就是一个请求和应答，可以理解为一个键值对就是一组会话
    private Map<String, User> sessions = new HashMap<>();
    
    public HttpServerV3(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
    }
    public void start() throws IOException {
        System.out.println("服务器启动");
        ExecutorService executorService = Executors.newCachedThreadPool();
        while (true) {
            Socket clientSocket = serverSocket.accept();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    process(clientSocket);
                }
            });
        }
    }

    private void process(Socket clientSocket) {
        try {
            //1.计算请求并且解析
            HttpRequest request = HttpRequest.build(clientSocket.getInputStream());
            HttpResponse response = HttpResponse.build(clientSocket.getOutputStream());
            //2.根据请求计算响应
            //方法是get下如何处理
            if ("GET".equalsIgnoreCase(request.getMethod())) {
                doGET(request, response);
            //方法是post如何处理
            } else if ("POST".equalsIgnoreCase(request.getMethod())) {
                doPOST(request, response);
            } else {
                response.setStatus(405);
                response.setMessage("Method Not Allowed");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void doPOST(HttpRequest request, HttpResponse response) {
    }

    private void doGET(HttpRequest request, HttpResponse response) {

    }

}
