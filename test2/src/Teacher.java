public class Teacher {

    public String num;//工号
    public String name;
    public String sex;
    public String teach;//所教课程

    public Teacher(String num, String name, String sex, String teach) {
        this.num = num;
        this.name = name;
        this.sex = sex;
        this.teach = teach;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "num='" + num + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", teach='" + teach + '\'' +
                '}';
    }
}
