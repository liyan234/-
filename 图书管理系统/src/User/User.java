package User;

import Book.BookList;
import Operation.IOperation;
import com.sun.org.apache.xpath.internal.operations.Operation;

public abstract class User {
    private String name;

    public IOperation[] Operations;

    public User(String name) {
        setName(name);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract int menu();

    public void doIOperation(BookList bookList,int choice) {
        Operations[choice].work(bookList);
    }
}
