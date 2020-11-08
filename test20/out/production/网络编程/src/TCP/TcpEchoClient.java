package TCP;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoClient {

    //1.启动客户端和服务器建立连接
    //2.进入主循环
    //   a.读取用户输入内容
    //   b.构造一个请求发送个服务器
    //   c.读取服务器的响应数据
    //   d.把响应数据显示在界面上

    private Socket socket = null;

    public TcpEchoClient(String severIP, int severPort) throws IOException {
        this.socket = new Socket(severIP, severPort);
    }

    public void start() {
        System.out.println("客户端启动");
        Scanner sc = new Scanner(System.in);
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())))
        {
            //1.读取用户输入内容
            while (true) {
                System.out.print("->");
                String request = sc.nextLine();
                if ("exit".equals(request)) {
                    break;
                }
                //2.构建请求并发送，记得换行 \n
                bufferedWriter.write(request + "\n");
                bufferedWriter.flush();
                //3.读取响应数
                String response = bufferedReader.readLine();
                //4.响应显示到界面上
                System.out.println(response);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
