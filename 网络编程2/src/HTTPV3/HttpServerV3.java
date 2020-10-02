package HTTPV3;



import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
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
        if (request.getUrl().startsWith("/login")) {
            String userName = request.getParameter("username");
            String password = request.getParameter("password");

            if ("li".equals(userName) && "123".equals(password)) {
                response.setStatus(200);
                response.setMessage("OK");
                response.setHeader("Content-Type", "text/html; charset=utf-8");

                String sessionId = UUID.randomUUID().toString();
                User user = new User();
                user.userName = "li";
                user.age = 20;
                user.school = "陕科大";
                sessions.put(sessionId, user);
                response.setHeader("Set-Cookie", "sessionId=" + sessionId);

                response.setBody("<html>");
                response.setBody("<div>欢迎" + userName + "</div>");
                response.setBody("</html>");
            } else {
                //登陆失败
                response.setStatus(403);
                response.setMessage("Forbidden");
                response.setHeader("Content-Type", "text/html; charset=utf-8");
                response.setBody("<html>");
                response.setBody("<div>登陆失败<div>");
                response.setBody("</html>");
            }
        }

    }

    private void doGET(HttpRequest request, HttpResponse response) throws IOException {
        //1.能够支持返回一个html文件
        String sessionId = request.getCookie("sessionId");
        User user = sessions.get(sessionId);

        if (sessionId == null || user == null) {
            //用户第一次登陆
            response.setStatus(200);
            response.setMessage("OK");
            response.setHeader("Content-Type", "text/html; charset=utf-8");
            //                          获取一个类的对象   获取当前类的“类加载器”   根据文件名再Resources的目录中找到对应文件
            InputStream inputStream = HttpServerV3.class.getClassLoader().getResourceAsStream("index.html");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
            while ((line = bufferedReader.readLine())!= null) {
                response.setBody(line + "\n");
            }
            bufferedReader.close();
        } else {
            //用户已经登陆，无法在登录
            response.setStatus(200);
            response.setMessage("OK");
            response.setHeader("Content-Type", "text/html; charset=utf-8");
            response.setBody("<html>");
            response.setBody("<div>" + "你已经登录了" + user.userName + "</div>");
            response.setBody(+ user.age + "div");
            response.setBody("<div>" + user.school + "</div>");
            response.setBody("</html>");
        }
    }
}
