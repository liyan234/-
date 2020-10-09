import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

class Cat {
    private String name = "小猫";

    public Cat (String name) {
        this.name = name;
    }
    public Cat () {

    }


    public void eat (String food) {
        System.out.println(this.name + "eat" + food);
    }

}


public class Reflect {
    public static void testInstance() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
   //通过反射来实例化对象
   // （1）//1.通过全限定类名类获取
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        Class catClass = Class.forName(name);
        //Class catClass = Class.forName("这个包名.类名");
        //2.通过雷的实列来获取
        Cat cat = new Cat("猫咪");
        Class catClass2 = cat.getClass();

        //3.通过类来直接获取
        Class catClass3 = Cat.class;
   //(2)获取这个类
        Cat cat1 = (Cat)catClass.newInstance();
        //不用new来获取这个类
    }

    //通过反射来获取对象的属性
    public static void testField () throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException {
        Class catClass = Class.forName("反射，枚举，lambda.Cat");

        //借助类对象，获取到指定的Field对象
        Field field = catClass.getDeclaredField("name");
        field.setAccessible(true);//由于name是private,要破坏封装

        //根据field来修改/获取对象的相关字段
        Cat cat = new Cat();
        //set修改
        field.set(cat,"xxxx");
        //get获取
        String name = (String) field.get(cat);
        System.out.println(name);
    }


    //通过类对象获取类的方法
    public static void testMethod() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InvocationTargetException {

        Class catClass = Class.forName("java16_0521.Cat");

        // 根据类对象, 根据名字获取到指定的 Method 对象
        Method method = catClass.getMethod("eat", String.class);
        method.setAccessible(true);

        // 借助 Method 对象来调用指定的方法(对于非静态方法, 需要指定实例来调用).
        Cat cat = new Cat();
        method.invoke(cat, "鱼");
    }

    //通过类对象获取类的构造方法
    public static void testConstructor() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class catClass = Class.forName("java16_0521.Cat");

        // 借助类对象获取 Constructor 对象
        // 下面的操作意思是获取到参数为一个 String 的构造方法.
        Constructor constructor = catClass.getConstructor(String.class);
        constructor.setAccessible(true);

        //根据 Constructor 实例化对象
        Cat cat = (Cat) constructor.newInstance("小黑");

        cat.eat("猫粮");
    }
}
