public class Test {
    public static void main(String[] args) {
        Human human = new Human("张三","男",22);
        Student student = new Student("张四","男",24,"1234","陕科大");
        Teacher teacher = new Teacher("王五","男",21,"陕科大","2371823");
        UnStudent unStudent = new UnStudent("李四","男",19,"21312","陕西科技大学","物理");
        //错误：Student student1 = new Human("张三","nan",25);
        //子类的属性是多于父类的
        //可以用子类的构造方法来实例化父类对象
        //不可以用父类的构造方法来实例化子类的对象
        //用子类构造方法实例化父对象，该对象调用的方法仅限与父类中定义的方法。
        Student student3 = new UnStudent("小小","女",18,"123","陕西科技大学","英语");
        Human human1 = new Human("z","nan",21);
        Human human2 = new Human("z","nan",21);
       // System.out.println(human1.equals(human2));
        System.out.println(human1);



        Student student1 = new Student("张三","男",22,"001","陕科大");
        Student student2 = new Student("张三","男",22,"001","陕科大");
       // System.out.println(student1.equals(student2));
        System.out.println(student1);


        UnStudent unStudent2 = new UnStudent("李四","男",22,"002","陕科大","物理");
        UnStudent unStudent3 = new UnStudent("李四","男",22,"002","陕科大","物理");
        //System.out.println(unStudent2.equals(unStudent3));
        System.out.println(unStudent2);
    }
}
