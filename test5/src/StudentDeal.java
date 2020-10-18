import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

//输入输出的
public class StudentDeal {

    public static String  findNameByNum(String Num) {//通过学号来查询姓名
        String name = "查无此人";//定义一个变量来保存查询的结果
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\123.txt"));
            String temp = bufferedReader.readLine();//读入一行

            while(temp != null) {
                System.out.println();
                String[] arrays = temp.split(",");
                if(arrays[0].equals(Num)) {
                    name = arrays[1];
                    break;
                }
                temp = bufferedReader.readLine();//再次读取一行
            }
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        //从学生文件中一次读取一行数据（用BufferedReader对象来实现一次读取一行数据的功能）
        //将一行数据用切割函数切割成一个字符串数组，然后比对
        //怎么来判断到达了文件的尾部(通过判空来判断是否到文件的尾部)
        //返回结果
        return name;
    }
    public static String[]  findNumByName(String name) {//通过学号来查询姓名
       ArrayList<String> ret = new ArrayList<>();//定义一个变量来保存查询的结果
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\123.txt"));
            String temp = bufferedReader.readLine();//读入一行

            while(temp != null) {
                System.out.println();
                String[] arrays = temp.split(",");
                if(arrays[1].equals(name)) {
                    ret.add(arrays[0]);
                }
                temp = bufferedReader.readLine();//再次读取一行
            }
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        //从学生文件中一次读取一行数据（用BufferedReader对象来实现一次读取一行数据的功能）
        //将一行数据用切割函数切割成一个字符串数组，然后比对
        //怎么来判断到达了文件的尾部(通过判空来判断是否到文件的尾部)
        //返回结果
        return (String[])  ret.toArray (new String [ret.size()] );
    }

    public static void main(String[] args) {

        //System.out.println(findNameByNum("9"));
        //System.out.println(Arrays.toString(findNumByName("张一")));

        
    }
}
