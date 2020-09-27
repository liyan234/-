package Book;

public class BookList  {

    private Book[] books = new Book[10];
    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public BookList (){
        this.books[0] = new Book("斗破苍穹","20","天蚕土豆");
        this.books[1] = new Book("斗罗大陆","21","唐家三少");
        this.books[2] = new Book("奥特曼打小怪兽","21","小怪兽");

        this.size = 3;
    }

    public void setBook(Book book) {//add
        this.books[size] = book;
        this.size++;
    }

    public String getBook(int i) {//find , del
        return this.books[i].getName();
    }

    public void disA(int i) {//find
        System.out.println(books[i].toString());
    }

    public void setBooks(int pos ,Book book) {//del
        this.books[pos] = book;
    }

    public Book getBooks(int pos) {
        return this.books[pos];
    }

    public void disPlay() {//dis
        for (int i = 0; i < this.size ; i++) {
            System.out.println(books[i].toString());
        }
    }

}
