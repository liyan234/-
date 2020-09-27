package Operation;

import Book.BookList;

import java.util.Scanner;

public class ReturnOperation implements IOperation{
    @Override
    public void work(BookList bookList) {

        Scanner scan = new Scanner(System.in);
        System.out.println("输入要借阅书籍的名称");
        String name = scan.nextLine();
        for (int i = 0; i < bookList.getSize(); i++) {
            if (name.equals(bookList.getBook(i))) {
                bookList.getBooks(i).setBorrow(false);
                System.out.println("归还成功");
                return;
            }
        }
        System.out.println("没有此书");
    }
}
