import java.util.Scanner;

public class Driver {

    private String name;
    private String sex;
    private int age;
    private int driAge;//驾龄
    private String dirNum;//驾照编号

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

    public int getDriAge() {
        return driAge;
    }

    public void setDriAge(int driAge) {
        this.driAge = driAge;
    }

    public String getDirNum() {
        return dirNum;
    }

    public void setDirNum(String dirNum) {
        this.dirNum = dirNum;
    }

    public Driver(String name,String sex,int age,int driAge,String dirNum) {
        setName(name);
        setSex(sex);
        setAge(age);
        setDriAge(driAge);
        setDirNum(dirNum);
    }
}
