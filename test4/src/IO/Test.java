package IO;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        StudentDel studentDel = new StudentDel();
        Student[] students = studentDel.findStuByLastName("张");

        System.out.println(Arrays.toString(students));
        Student student = new Student("11","六十","女");

        studentDel.addNewStudent(student);
    }
}
