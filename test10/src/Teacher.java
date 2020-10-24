

public class Teacher extends Human {

    public Teacher(String name, String sex, int age , String schoolName , String num) {
        super(name, sex, age);
        setSchoolName(schoolName);
        setCourse(num);
    }

    private String schoolName;//所在学校
    private String num;//工号

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getCourse() {
        return num;
    }

    public void setCourse(String num) {
        this.num = num;
    }

    public void teach() {
        System.out.println( getName() + "在上课" );
    }
    public void ready() {
        System.out.println( getName() + "在备课" );
    }
}
