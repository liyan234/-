package User;

import Operation.*;

import java.util.Scanner;

public class AdminUser extends User{

    public AdminUser(String name) {
        super(name);
        this.Operations = new IOperation[] {
                new ExitOperation(),
                new FindOperation(),
                new DelOperation(),
                new AddOperation(),
                new DisplayOperation(),
        };
    }

    public int menu() {
        Scanner scan = new Scanner(System.in);
        System.out.println(getName() + "欢迎来到图书馆");
        System.out.println("=== 0 退出系统 ==");
        System.out.println("=== 1 查找图书 ==");
        System.out.println("=== 2 删除图书 ==");
        System.out.println("=== 3 新增图书 ==");
        System.out.println("=== 4 显示所有图书 ==");
        int choice = scan.nextInt();
        return choice;
    }
}
