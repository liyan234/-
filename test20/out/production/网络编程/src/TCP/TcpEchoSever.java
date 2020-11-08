package TCP;

//Tcp不需要封装成DatagramPacket，和UDP完全不一样

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpEchoSever {

    // 1. 初始化服务器
    // 2. 进入主循环
        // 1)先从内核中获取到一个TCP的连接
        // 2)处理这个TCP的连接
            // a 读取请求并解析
            // b 根据请求计算响应
            // c 把响应写回给客户端

    //初始化服务器
    private ServerSocket serverSocket = null;


    public TcpEchoSever(int port) throws IOException {
        //关联服务器的时候，需要先绑定端口号
        this.serverSocket = new ServerSocket(port);
    }

    //服务器启动
    public void start() throws IOException {
        System.out.println("服务器启动");

        while (true) {
            // 从内核中获取到一个TCP连接
            // 建立连接后才可以响应服务器
            Socket clientSocket = serverSocket.accept();
            //然后我们需要处理这个连接
            prcessConnection(clientSocket);
        }
    }

    public void prcessConnection(Socket clientSocket) {
        System.out.printf("[%s:%d] 客户端上线 \n",
                clientSocket.getInetAddress().toString(),
                clientSocket.getPort());
        // 我们用 clientSocket 来和客户端交互，先准备好交互工作。
        // 获取到 clientSocket 的流对象，必须要用BufferReader和BufferWriter
        //                                                          强转成字符流                      字节流对象
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {
            //TCP的实现有长连接和短连接
            //长连接就是一次请求后可以多次发送消息，处理多个请求和响应
            //短连接就是一次请求后只能发送一条消息，处理一个请求和消息
            //没有这个while(true)就是短连接了
            while (true) {
                //1 解析请求
                //注意我们一次读一行，
                String request = bufferedReader.readLine();
                //2 根据请求计算响应
                String response = process(request);
                //3 响应写回服务器
                // 这个换行符与上面的读一行对应
                bufferedWriter.write(response + "\n");
                // 刷新缓冲区，非常重要，不刷新的话缓冲区的所写的数据无法从缓冲区中到Socket中
                bufferedWriter.flush();

                //同样，我们打印一条日志
                System.out.printf("[%s : %d] req: %s; resp: %s \n");
            }
        } catch (IOException e) {
            //发生异常的时候，我们的客户端就下线了
            System.out.printf("[%s:%d] 客户端下线 \n", clientSocket.getInetAddress().toString(),
                    clientSocket.getPort());
        }
    }

    public String process(String request) {
        return request;
    }
}
