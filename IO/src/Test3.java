import java.io.*;

public class Test3 implements Serializable {

    static class Student  implements Serializable{
        public String name;
        public int age;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student s = new Student();
        s.name = "lll";
        s.age = 20;
        //序列化
        serializeStudent(s);

        Student s2 = deserializeStudent();
        System.out.println(s.name);
        System.out.println(s.age);
    }

    private static Student deserializeStudent() throws IOException, ClassNotFoundException {

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("c:/Test1.txt") );
        Student s = (Student) objectInputStream.readObject();
        return s;
    }

    private static void serializeStudent(Student s) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("c:/Test1.txt"));

        objectOutputStream.writeObject(s);
        objectOutputStream.close();
    }
}
