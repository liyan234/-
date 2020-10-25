public class Learning {
    public static void main(String[] args) {

        //公交车内函数的实现
        //定义了一个公车对象
        Bus bus = new Bus("陕A 231","336",15,"06:00","24:00");
        //定义了五个乘客对象
        Passage pa1 = new Passage("张一","男",21);
        Passage pa2 = new Passage("张二","男",22);
        Passage pa3 = new Passage("张三","男",23);
        Passage pa4 = new Passage("张四","男",24);
        Passage pa5 = new Passage("张五","男",25);

        bus.upAPassage(pa1);
        Passage[] upPass = {pa3,pa4,pa5};
        bus.up(upPass);

        bus.downAPassage(pa1);
        Passage[] downPass= {pa3,pa4,pa5};
        bus.downPassages(downPass);
/*
        Customer customer1 = new Customer("张三", "男", 80.5f);
        Customer customer2 = new Customer("王五", "男", 90.0f);

        Book book1 = new Book("书一","121",41.5f);
        Book book2 = new Book("书二","122",42.5f);
        Book book3 = new Book("书三","123",43.5f);
        Book book4 = new Book("书四","124",44.5f);
        Book book5 = new Book("书五","125",45.5f);

        Book[] books1 = new Book[]{book1,book2,book3,book4,book5};
        BookStore store = new BookStore("科大书店","科大后街",books1);

        store.sellABook(customer1,book1);
        store.sellABook(customer1,book5);

        Book[] buyBooks = new Book[]{book1,book2};

        store.sellBooks(customer2,buyBooks);*/

    }
}
