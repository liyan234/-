
public class Ship extends Traffic {
    public Ship () {
    }

    public Ship(String name,int age) {
        super(name, age);
    }

    public void run() {
        System.out.println("在海上航行");
    }
}
