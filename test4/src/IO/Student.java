package IO;

public class Student {

    public String num;
    public String name;
    public String sex;

    public Student(String num, String name, String sex) {
        this.num = num;
        this.name = name;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "num='" + num + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
