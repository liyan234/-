import java.util.Arrays;

public class Main {


    public static void main(String[] args) {

         Student[] students = new Student[3];
         students[0] = new Student("李",16,"78");
         students[1] = new Student("白",18,"99");
         students[2] = new Student("王",17,"89");

         System.out.println(Arrays.toString(students));
         Arrays.sort(students);
         System.out.println(Arrays.toString(students));

    }

}
