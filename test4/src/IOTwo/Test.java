package IOTwo;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Test {


    public static void main(String[] args) throws IOException {
        TeacherDel teacherDel = new TeacherDel();
        System.out.println( teacherDel.findTeacherByNum("t01") );
        System.out.println( teacherDel.findTeacherByNum("t1"));

        Teacher teacher = new Teacher("1994","lili","nv","kkk");
        teacherDel.addTeacher(teacher);


        teacherDel.delTeacher("1994");

    }




}
