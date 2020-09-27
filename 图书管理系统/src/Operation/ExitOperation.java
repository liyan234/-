package Operation;

import Book.BookList;

public class ExitOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("exit");
        System.exit(0);
    }
}
