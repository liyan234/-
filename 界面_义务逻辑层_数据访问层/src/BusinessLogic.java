public class BusinessLogic {
//业务逻辑类需要去调用学生的数据访问类

//传统的形式，是不是先要把学生的数据访问类实现（代码写完）才能去实现业务逻辑类的代码

//业务逻辑类的程序员需要等所有的数据访问类都实现了才可以着手写代码

//业务逻辑层依赖于数据访问层，界面层依赖于业务逻辑层

// 一般业务逻辑层为调用类，数据访问层被调用
// 调用类和被调用类的程序员需要去商量确定它们之间的方法
// 调用类需要告知被调用类需要提供一个具有什么功能的方法
// 被调用类需要告知调用类需要提供什么输入参数
// 根据讨论的结果来定义一个接口
// 开始并行开发
// 被调用类要实现定义好的接口，
// 调用类来说为了实现调用类的代码逻辑，需要在调用类中去创建一个定义好的接口对象

// 为了测试的需要，调用类可以再写一个实现接口的测试类
// 当被调用的类完成后用被调用类来实例化接口对象

    public int[] findExamByStuName(String stuName) {
        return null;
    }
}

