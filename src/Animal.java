//一个类中只要有一个或者一个以上的抽象方法的话，这个类必定是一个抽象类
//抽象类中不一定包含有抽象方法
public abstract class Animal {

    private String name;
    private int age;

    public Animal() {

    }

    public Animal(String name,int age) {
        setName(name);
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //动物共有的两个行为用抽象方法来表示
    //只要类中有一个抽象方法，那这个定义必须被定义为抽象类
    public abstract void eat();
    public abstract void sleep();

}
