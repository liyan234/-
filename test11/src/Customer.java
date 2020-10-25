public class Customer {
    private String name;
    private String sex;
    private float money;

    public Customer(String name,String sex,float money) {
        setName(name);
        setSex(sex);
        setMoney(money);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public float getMoney() {
        return money;
    }
    public void setMoney(float money) {
        if(money > 0) {
            this.money = money;
        }
    }
}
