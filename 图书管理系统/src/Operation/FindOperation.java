package Operation;

import Book.BookList;

import java.util.Scanner;

public class FindOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        Scanner scan = new Scanner(System.in);
        System.out.println("输入这个书籍得名称");
        String name = scan.nextLine();
        for (int i = 0; i < bookList.getSize(); i++) {
            if(name.equals(bookList.getBook(i))) {
                System.out.println("找到了");
                bookList.disA(i);
                return;
            }
        }
        System.out.println("没有这本书");
    }
}
