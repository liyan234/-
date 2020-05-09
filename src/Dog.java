public class Dog extends Animal{

    public Dog(String name,int age) {
        super(name, age);
    }

    public void eat() {
        System.out.println("狗吃骨头");
    }
    public void sleep() {
        System.out.println("狗趴着睡");
    }
}
