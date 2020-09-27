package Book;

public class Book {
    private String name;//名字
    private String price;//价格
    private String author;//作者
    private boolean isBorrow;//是否借出

    public Book() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isBorrow() {
        return isBorrow;
    }

    public void setBorrow(boolean borrow) {
        isBorrow = borrow;
    }

    public Book (String name, String price, String author) {
        this.name = name;
        this.price = price;
        this.author = author;
        this.isBorrow = false;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", author='" + author + '\'' +
                ", " + (isBorrow ? "已借出":"未被借出") +
                '}';
    }
}
