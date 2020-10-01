package HttpV2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServerV2 {

    private ServerSocket serverSocket = null;

    public HttpServerV2(int port) throws IOException {
        serverSocket = new ServerSocket(port);
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
            HttpRequest request = HttpRequest.build(clientSocket.getInputStream());
            System.out.println("request: " + request);
            HttpResponse response = HttpResponse.build(clientSocket.getOutputStream());
            response.setHeaders("Content-Type", "text/html");

            if (request.getUrl().startsWith("/hello")) {
                response.setStatus(200);
                response.setMessage("OK");
                response.setBody("<h1>hello<h1>");
            }
            //刷新很重要
            response.flush();
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
}
