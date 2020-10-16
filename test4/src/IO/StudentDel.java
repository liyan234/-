package IO;

import IOTwo.Teacher;
import sun.reflect.generics.repository.FieldRepository;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class StudentDel {

    public  String[]  findNumByName(String name) {//通过学号来查询姓名
        ArrayList<String> ret = new ArrayList<>();//定义一个变量来保存查询的结果
        try {
            FileReader fileReader = new FileReader("C:C:\\Users\\所谓爱隔山海\\Desktop\\123.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
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
            fileReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        //从学生文件中一次读取一行数据（用BufferedReader对象来实现一次读取一行数据的功能）
        //将一行数据用切割函数切割成一个字符串数组，然后比对
        //怎么来判断到达了文件的尾部(通过判空来判断是否到文件的尾部)
        //返回结果
        return (String[])  ret.toArray (new String [ret.size()] );
    }

    public Student[] findStuByLastName(String lastName) {
        ArrayList<Student> arrayList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("C:\\Users\\所谓爱隔山海\\Desktop\\123.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String temp = bufferedReader.readLine();//读入一行

            while(temp != null) {
                System.out.println();
                String[] arrays = temp.split(",");
                if(arrays[1].startsWith(lastName)) {
                    arrayList.add(new Student(arrays[0],arrays[1],arrays[2]));
                }
                temp = bufferedReader.readLine();//再次读取一行
            }
            bufferedReader.close();
            fileReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return (Student[])arrayList.toArray(new Student[arrayList.size()]);
    }

    public Student[] findStuContainWord(String word) {
        ArrayList<Student> arrayList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("C:\\Users\\所谓爱隔山海\\Desktop\\123.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String temp = bufferedReader.readLine();//读入一行

            while(temp != null) {
                System.out.println();
                String[] arrays = temp.split(",");
                if(arrays[1].contains(word)) {
                    arrayList.add(new Student(arrays[0],arrays[1],arrays[2]));
                }
                temp = bufferedReader.readLine();//再次读取一行
            }
            bufferedReader.close();
            fileReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return (Student[])arrayList.toArray(new Student[arrayList.size()]);
    }

    public void addNewStudent(Student stu){
        if(stu != null) {
            if(!checkNumIsExist(stu.num)) {
                try {
                    FileWriter fileWriter = new FileWriter("C:\\Users\\所谓爱隔山海\\Desktop\\123.txt",true);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    StringBuffer stringBuffer = new StringBuffer();

                    stringBuffer.append(stu.num + ",");
                    stringBuffer.append(stu.name + ",");
                    stringBuffer.append(stu.sex + ",");

                    bufferedWriter.newLine();

                    bufferedWriter.write(stringBuffer.toString());
                    bufferedWriter.close();
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    //为上面的方法做辅助
    private boolean checkNumIsExist(String num) {
        boolean ret = false;
        try {
            FileReader fileReader = new FileReader("C:\\Users\\所谓爱隔山海\\Desktop\\123.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String temp = bufferedReader.readLine();//读入一行

            while(temp != null) {
                System.out.println();
                String[] arrays = temp.split(",");
                if(arrays[0].equals(num)) {
                    ret = true;
                    break;
                }
                temp = bufferedReader.readLine();//再次读取一行
            }
            bufferedReader.close();
            fileReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }






}
