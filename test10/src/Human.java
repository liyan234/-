
//定义一个父类
public class Human {
    private String name;
    private String sex;
    private int age;

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

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
            this.age = age;
    }

    public Human(String name, String sex, int age) {
        setName(name);
        setSex(sex);
        setAge(age);
    }

    public void eat() {
        System.out.println(name + "在吃饭");
    }
    public void sleep() {
        System.out.println(name + "在睡觉");
    }

    public boolean equals(Human human) {
        boolean flag = false;
        if(human.name.equals(name) && human.sex.equals(sex) && human.age == age){
            flag = true;
        }
        return flag;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age ;
    }
}


