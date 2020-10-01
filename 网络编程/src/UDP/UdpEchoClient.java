package UDP;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UdpEchoClient {
    // 客户端的主要流程分成四步.
    // 1. 从用户这里读取输入的数据.
    // 2. 构造请求发送给服务器
    // 3. 从服务器读取响应
    // 4. 把响应写回给客户端.

    private DatagramSocket socket = null;
    private String serverIp;
    private int serverPort;

    // 需要在启动客户端的时候来指定需要连接哪个服务器
    // 我们需要输入ip地址，和端口号。
    //  然后 这个socket 会自动和服务器的连接，
    //  就是这个socket 就会被实列化
    public UdpEchoClient(String serverIp, int serverPort) throws SocketException {
        this.serverIp = serverIp;
        this.serverPort = serverPort;
        socket = new DatagramSocket();
    }

    public void start() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // 1. 读取用户输入的数据
            System.out.print("-> ");
            String request = scanner.nextLine();
            if (request.equals("exit")) {
                break;
            }

            // 2. 构造请求发送给服务器
                  //我们这个request 必须封装成DatagramPacket,然后才可以发送过去
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(),
                    request.getBytes().length, InetAddress.getByName(serverIp),
                    serverPort);//这个与端口号建立连接
                 //发送过去
            socket.send(requestPacket);
            // 3. 从服务器读取响应
                 //服务器读过来的也是DatagramPacket。
            DatagramPacket responsePacket = new DatagramPacket(new byte[4096], 4096);
                //接受信号。
            socket.receive(responsePacket);
                // 然后解封。
            String response = new String(responsePacket.getData(), 0, responsePacket.getLength()).trim();
            // 4. 显示响应数据
            System.out.println(response);
        }
    }


    public static void main(String[] args) throws IOException {
        UdpEchoClient client = new UdpEchoClient("127.0.0.1", 9090);
        client.start();
    }
}
