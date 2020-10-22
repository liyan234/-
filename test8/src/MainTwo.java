public class MainTwo {
    public static void main(String[] args) throws CloneNotSupportedException {

        Person person1 = new Person("li",12);

        Person person2 = (Person) person1.clone();//需要强转，clone时Object

        System.out.print(" p1 = " + person1.getAge());
        System.out.print(" p2 = " + person2.getAge());

        System.out.println();
        person1.setAge(19);

        System.out.print(" p1 = " + person1.getAge());
        System.out.print(" p2 = " + person2.getAge());

        //处理异常的两种方式
       /* try {
            Person person2 = (Person) person1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }*/

    }
}
