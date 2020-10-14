import java.io.*;
import java.util.ArrayList;

public class TeacherDel {

    public String findTeacherByNum(String num) {

        String name = "查无此人";

        try {

            FileReader fileReader = new FileReader("C:\\Users\\所谓爱隔山海\\Desktop\\teacher.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String tmp = bufferedReader.readLine();
            while(tmp != null) {
                String[] A = tmp.split(",");
                if(A[0].equals(num)) {
                    name = A[1];
                    break;
                }
                tmp = bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return name;
    }


    public String[] findNumByName(String name) {

        ArrayList<String> result = new ArrayList<>();
        //用一个容器来储存所得到的对象
        try {

            FileReader fileReader = new FileReader("C:\\Users\\所谓爱隔山海\\Desktop\\teacher.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String temp = bufferedReader.readLine();
            while(temp != null) {
                String[] A = temp.split(",");
                if(A[1].equals(name)) {
                    result.add(A[0]);
                }
                temp = bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (String[])result.toArray(new String[result.size()]);
        //强制转换
    }

    public Teacher findTeaByNum(String num) {
        Teacher teacher = null;

        try {

            FileReader fileReader = new FileReader("C:\\Users\\所谓爱隔山海\\Desktop\\teacher.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String temp = bufferedReader.readLine();

            while(temp != null) {
                String[] A = temp.split(",");
                if(A[0].equals(num)) {
                    teacher = new Teacher(A[0],A[1],A[2],A[3]);
                    break;
                }
                temp = bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return teacher;
    }


    //读取所有的教师信息,,抛出异常
    public Teacher[] getAllOne() throws IOException {
        ArrayList<Teacher> result = new ArrayList<>();

        FileReader fileReader = new FileReader("C:\\Users\\所谓爱隔山海\\Desktop\\teacher.txt");

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String temp = bufferedReader.readLine();

        while(temp != null) {
            String[] str = temp.split(",");
            result.add(new Teacher(str[0],str[1],str[2],str[3]));
            temp = bufferedReader.readLine();
        }
        bufferedReader.close();
        fileReader.close();
        return (Teacher[])result.toArray(new Teacher[result.size()]);
    }


//增加教师信息
    public void addTeacher(Teacher teacher) {

        if(teacher != null) {
            try {
                if(!checkIsExist(teacher.num)) {

                    FileWriter fileWriter = new FileWriter("C:\\Users\\所谓爱隔山海\\Desktop\\teacher.txt",true);

                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                    StringBuffer stringBuffer = new StringBuffer();

                    stringBuffer.append(teacher.num + ",");
                    stringBuffer.append(teacher.name + ",");
                    stringBuffer.append(teacher.sex+ ",");
                    stringBuffer.append(teacher.teach);
                    bufferedWriter.newLine();
                    bufferedWriter.write(stringBuffer.toString());
                    //写入
                    bufferedWriter.close();
                    fileWriter.close();

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }



    private boolean checkIsExist(String num) throws IOException {

        boolean judge = false;
        FileReader fileReader = new FileReader("C:\\Users\\所谓爱隔山海\\Desktop\\teacher.txt");

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String tmp = bufferedReader.readLine();
        while(tmp != null) {
            String[] A = tmp.split(",");
            if(A[0].equals(num)) {
                judge = true;
                break;
            }
            tmp = bufferedReader.readLine();
        }
        bufferedReader.close();
        fileReader.close();
        return judge;
    }

    //通过一个链表来获取所有的教师记录
    public ArrayList<Teacher> getAll() throws IOException {
        ArrayList<Teacher> result = new ArrayList<>();

        FileReader fileReader = new FileReader("C:\\Users\\所谓爱隔山海\\Desktop\\teacher.txt");

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String temp = bufferedReader.readLine();

        while(temp != null) {
            String[] A = temp.split(",");
            Teacher teacher = new Teacher(A[0],A[1],A[2],A[3]);
            result.add(teacher);
            temp = bufferedReader.readLine();
        }
        return result;
    }
    //通过教师编号删除教师记录
    public void delTeacher(String num) throws IOException {
        ArrayList<Teacher> T = getAll();
    //先将这个容器中的不要的教师对象删除
        for (Teacher temp: T) {
            if(temp.num.equals(num)) {
                T.remove(temp);
                break;
            }
        }
        //删除后将这个容器中的内容 覆盖式写入
        FileWriter fileWriter = new FileWriter("C:\\Users\\所谓爱隔山海\\Desktop\\123.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        for (Teacher a: T) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(a.num + ",");
            stringBuffer.append(a.name + ",");
            stringBuffer.append(a.sex + ",");
            stringBuffer.append(a.teach );
            bufferedWriter.write(stringBuffer.toString());
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        fileWriter.close();
    }


    //修改教师记录
    public void upDate(Teacher teacher) throws IOException {
        ArrayList<Teacher> T = getAll();

        for(Teacher temp : T) {
            if(temp.num.equals(teacher.num) ) {
                T.remove(temp);
                T.add(teacher);
                break;
            }
        }
        //还是需要覆盖式写入
        FileWriter fileWriter = new FileWriter("C:\\Users\\所谓爱隔山海\\Desktop\\123.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for(Teacher tmp : T) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(tmp.num + ",");
            stringBuffer.append(tmp.name + ",");
            stringBuffer.append(tmp.sex + ",");
            stringBuffer.append(tmp.teach);
            bufferedWriter.write(stringBuffer.toString());
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        fileWriter.close();
    }
}
