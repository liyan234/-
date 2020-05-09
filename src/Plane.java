public class Plane extends Traffic {

    public Plane() {

    }
    public Plane(String name,int age) {
        super(name, age);
    }

    public void run() {
        System.out.println("在天上飞");
    }
}
