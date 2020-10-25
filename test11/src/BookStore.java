public class BookStore {
    private String bookName;//店名、
    private String address;
    private Book[] books;

    public BookStore(String bookName,String address,Book[] books) {
        setBookName(bookName);
        setAddress(address);
        setBooks(books);
    }

    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Book[] getBooks() {
        return books;
    }
    public void setBooks(Book[] books) {
        this.books = books;
    }

    //卖一本书
    //两个参数，一个是顾客，一个是顾客买的书
    public void sellABook(Customer customer,Book book) {
        if(customer.getMoney() >= book.getPrice()) {
            //需要判断顾客的钱是否够买
            for (int i = 0; i < books.length; i++) {
                if(books[i] != null) {
                    //假定书店中所有书不重名
                    if(books[i].getName().equals((book.getName()))) {
                        books[i] = null;//对应的书籍对象设为空
                        customer.setMoney(customer.getMoney() - book.getPrice());
                        //处理顾客的余额
                        System.out.println(customer.getName() + "买了" + book.getName() + "这本书");
                        System.out.println(customer.getName() + "剩下" + customer.getMoney() + "元");
                        break;
                    }
                }
            }

        } else {
            System.out.println(customer.getName() + "的钱不够买这本" + book.getName());
        }
    }

    public void sellBooks(Customer customer,Book[] books2) {
        float sumPrice = 0;
        for (int i = 0; i < books2.length; i++) {
            sumPrice = sumPrice + books2[i].getPrice();
        }
        if(customer.getMoney() >= sumPrice) {
            //需要判断顾客的钱是否够买
            customer.setMoney(customer.getMoney() - sumPrice);
            System.out.print(customer.getName() + "买下");
            for (int j = 0; j <books2.length ; j++) {
                System.out.print("<" + books2[j].getName() + ">");
            }
            System.out.println();
            System.out.println(customer.getName() + "剩下" + customer.getMoney() + "元");

        } else {
            System.out.print(customer.getName() + "的钱不够买");
            for (int n = 0; n < books2.length ; n++) {
                System.out.print("<" + books2[n].getName() + ">");
            }
        }
    }
}
