public class MyStack {
    public int[] arrays = new int[100];
    public int userSize = 0;

    public MyStack() {
    }

    public MyStack(int[] arrays) {
        this.arrays = arrays;
    }

    //进栈
    public void push(int data) {
        this.arrays[this.userSize] = data;
        this.userSize++;
    }

    public Integer pop() {
        if(this.userSize <= 0) {
            return null;
        }
        int ret = this.arrays[this.userSize - 1];
        this.userSize--;
        return ret;
    }

    public Integer peek() {
        if(this.userSize <= 0) {
            return null;
        }
        int ret = arrays[this.userSize - 1];
        return ret;
    }

    public boolean empty() {
        if(this.userSize == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

       while(true) {
           Integer cur = stack.pop() ;
           if(cur == null) {
               break;
           }
           System.out.println(cur);
       }

    }
}
