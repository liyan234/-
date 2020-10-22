package src1;

public class Student {
    private String num;
    private String name;
    private int age;
    public void setNum(String num)throws StudentException {
        if(num.length()!=12)
        {
            throw new StudentException("学号不是12位");
            //输入具体的问题来产生一个匿名的自定义异常对象，并抛出
        }
        else
        {
            if(isAllDigit(num))
            {
                this.num = num;//只有当所输入的学号参数都是数字字符时才赋给属性学号
            }
            else
            {
                throw new StudentException("学号并不全是数字");
            }
        }
    }

    //判断字符串中是否全都是数字字符
    private boolean isAllDigit(String str)
    {
        boolean flag=true;
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            if((ch<'0')||(ch>'9'))
            {
                flag=false;
                break;
            }
        }
        return flag;
    }

    public String getNum() {
        return num;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setAge(int age) throws StudentException{
        if(age>=16)
        {
            this.age = age;
        }
        else
        {
            throw new StudentException("年龄值必须大于等于16");
        }
    }
    public int getAge() {
        return age;
    }

    public Student(String num,String name,int age)throws StudentException
    {
        setNum(num);
        setName(name);
        setAge(age);
    }
}
