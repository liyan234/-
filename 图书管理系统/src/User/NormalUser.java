package User;

import Operation.*;

import java.util.Scanner;

public class NormalUser extends User {

    public NormalUser(String name) {
        super(name);
        this.Operations = new IOperation[] {
                new ExitOperation(),
                new FindOperation(),
                new BorrowOperation(),
                new ReturnOperation(),
        };
    }


    public int menu() {
        Scanner scan = new Scanner(System.in);
        System.out.println(getName() + "欢迎来到图书馆");
        System.out.println("=== 0 退出系统 ==");
        System.out.println("=== 1 查找图书 ==");
        System.out.println("=== 2 借阅图书 ==");
        System.out.println("=== 3 归还图书 ==");
        int choice = scan.nextInt();
        return choice;
    }
}
