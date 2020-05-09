public abstract class Traffic {

    private String name;
    private int age;//使用了多少年

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

    public Traffic() {

    }
    public Traffic(String name,int age) {
        setName(name);
        setAge(age);
    }

    //抽象类
    public abstract void run();
}
