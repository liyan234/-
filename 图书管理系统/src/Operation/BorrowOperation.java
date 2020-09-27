package Operation;

import Book.BookList;

import java.util.Scanner;

public class BorrowOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        Scanner scan = new Scanner(System.in);
        System.out.println("输入要借阅书籍的名称");
        String name = scan.nextLine();
        for (int i = 0; i < bookList.getSize(); i++) {
            if (name.equals(bookList.getBook(i))) {
                if(!bookList.getBooks(i).isBorrow()) {
                    bookList.getBooks(i).setBorrow(true);
                    System.out.println("借阅成功");
                } else {
                    System.out.println("此书已被借阅");
                }
                return;
            }
        }
        System.out.println("没有此书");
    }
}
