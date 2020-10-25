public class Book {
    private String name;
    private String num;//编号
    private float price;//价格

    public Book(String name,String num,float price) {
        setName(name);
        setNum(num);
        setPrice(price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getNum() {
        return num;
    }
    public void setNum(String num) {
        this.num = num;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        if (price > 0) {
            this.price = price;
        }
    }
}
