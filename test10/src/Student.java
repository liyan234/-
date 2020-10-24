
//一个子类
//类头定义父类的名称，一个类只可以继承一个父类
public class Student extends Human{
    //定义子类的构造方法
    //子类的构造方法的输入参数包含两部分，
    //一部分是用来初始化继承于父类的属性，
    //另一部分是初始化自身所特有的属性
    public Student(String name, String sex, int age, String num, String schoolName) {
        //类的构造方法方法体中，
        //一部分初始化父类的属性，
        //super来调用父类的构造方法来初始化来继承父类的属性
        super(name, sex, age);
        //另一部分初始化自身特有的属性
        setNum(num);
        setSchoolName(schoolName);

    }
    //定义子类特有的属性
    private String num;//学号
    private String schoolName;//学校

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
//定义子类特有的方法
    public void doHomework() {
        System.out.println(getName() + "在做作业");
    }
    public void exam() {
        System.out.println(getName() + "在考试");
    }

    public boolean equals(Student student) {
        if (super.equals(student)) {//调用父类的方法
            if (student.num.equals(num) && student.schoolName.equals(schoolName)) {
                return true;
            }
            else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "num='" + num + '\'' +
                ", schoolName='" + schoolName + '\'';
    }
}
