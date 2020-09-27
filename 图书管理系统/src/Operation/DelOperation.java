package Operation;

import Book.Book;
import Book.BookList;

import java.util.Scanner;

public class DelOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        Scanner scan = new Scanner(System.in);
        System.out.println("输入删除书籍的名称");
        String name = scan.nextLine();
        for (int i = 0; i < bookList.getSize(); i++) {
            if(name.equals(bookList.getBook(i))) {
                for (int j = i; j < bookList.getSize(); j++) {
                    Book book = bookList.getBooks(j+1);
                    bookList.setBooks(j,book);
                }
                bookList.setSize(bookList.getSize() - 1);
                System.out.println("删除成功");
                return;
            }
        }
        System.out.println("没有此书");
    }
}
