package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoServer {
    //对于一个服务器程序来说，核心流程也是要分成两步

    //1.进行初始化操作（实列化socket对象）
    //2.进入主循环，接受并处理请求
    // a 读取数据并解析
    // b 根据请求计算响应
    // c 把响应结果写回到客户端
    private DatagramSocket socket = null;

    public UdpEchoServer(int port) throws SocketException {
       this.socket = new DatagramSocket(port);
    }

    //服务器的启动代码
    public void start() throws IOException {
        System.out.println("服务器启动");

        while (true) {
            //a 读取请求并解析
            //字节流
                 //构建一个requestPacket
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096], 4096);
                //得到的数据为放入requestPacket
            socket.receive(requestPacket);
                 //这一步可以理解为解封装
            String request = new String(requestPacket.getData(),
                    0, requestPacket.getLength());
            //b 根据请求计算响应
                 //构建一个函数，专门来写服务器的回应
            String response = process(request);
            //c 把响应写回到客户端，响应数据就是response
                //把响应封装成Packet
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),
                    response.getBytes().length, requestPacket.getSocketAddress());
            //然后发送给客户端
            socket.send(responsePacket);
            //发送完之后，这个服务器就基本写完了，我们可以打印一条请求请求日志
            //格式化打印
            System.out.printf("[%s:%d] req: %s; resp :%s \n", requestPacket.getAddress().toString(),
                    requestPacket.getPort(), request, response);
        }
    }

    //回文，最简单的服务器
    public String process(String request) {
        return request;
    }

}
