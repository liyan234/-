

public class UnStudent extends Student {

    private String prof;//所在专业

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    public UnStudent(String name, String sex, int age, String num, String schoolName, String prof) {
        super(name, sex, age, num, schoolName);
        setProf(prof);
    }

    public boolean equals(UnStudent unStudent) {
        if(super.equals(unStudent)) {
            if(unStudent.prof.equals(prof)) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return super.toString()  +
                ",prof='" + prof + '\'' ;
    }
}
