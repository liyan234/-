import Book.BookList;
import User.AdminUser;
import User.NormalUser;
import User.User;


import java.util.Scanner;

public class Main {

    public static User login() {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入名字<");
        String name = scan.nextLine();
        System.out.println("请输入你的身份< 1 管理员 0 普通用户");
        int choice = scan.nextInt();

        if(choice == 1) {
            return new AdminUser(name);
        } else  {
            return new NormalUser(name);
        }
    }


    public static void main(String[] args) {
        //准备书籍
        BookList bookList = new BookList();
        //登录
        User user = login();

        while (true) {
            int choice = user.menu();
            //根据选择来确定调用方法
            user.doIOperation(bookList, choice);
        }
    }
}
