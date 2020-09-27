package Operation;

import Book.Book;
import Book.BookList;

import java.util.Scanner;

public class AddOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        Scanner scan = new Scanner(System.in);
        Book book = new Book();
        System.out.println("输入书名");
        book.setName(scan.nextLine());
        System.out.println("输入价格");
        book.setPrice(scan.nextLine());
        System.out.println("输入作者");
        book.setAuthor(scan.nextLine());
        bookList.setBook(book);
        System.out.println("成功添加");
    }
}
