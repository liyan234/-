package TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TcpThreadPoolEchoServer {

    private ServerSocket serverSocket = null;

    public TcpThreadPoolEchoServer(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");

        //先创建一个线程池实例
        //为了避免频繁的创建线程，而导致开销过大
        ExecutorService executorService = Executors.newCachedThreadPool();

        while (true) {
            Socket clientSocket = serverSocket.accept();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    processConnection(clientSocket);
                }
            });
        }



    }

    public void processConnection(Socket clientSocket) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((clientSocket.getInputStream())));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {
            while (true) {
                String request = bufferedReader.readLine();
                String response = process(request);
                bufferedWriter.write(response + "\n");
                bufferedWriter.flush();

                System.out.printf("[%s:%d] req %s; resp: %s \n", clientSocket.getInetAddress().toString(),
                         clientSocket.getPort(),request,response);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String process(String request) {
        return request;
    }

}
