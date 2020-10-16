import java.util.LinkedList;
import java.util.Queue;

//用队列表示栈
public class MyStack {

    Queue<Integer> A = new LinkedList<>();
    Queue<Integer> B = new LinkedList<>();

    public MyStack() {

    }

    public void push(int x) {
        this.A.offer(x);
    }

    public int pop() {
        if(empty()) {
            return -1;
        }
        while(this.A.size() > 1) {
            int cur = this.A.poll();
            this.B.offer(cur);
        }
        int x = this.A.poll();
        swap();
        return x;
    }

    private void swap() {
        Queue<Integer> tmp = this.B;
        this.B = this.A;
        this.A = tmp;
    }

    public int top() {
        if(empty()) {
            return -1;
        }
        while(this.A.size() > 1) {
            int cur = this.A.poll();
            this.B.offer(cur);
        }
        int x = this.A.poll();
        this.B.offer(x);
        swap();
        return x;

    }

    public boolean empty() {
        return this.A.isEmpty() && this.B.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);

        System.out.println(myStack.top());

        System.out.println(myStack.empty());

        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());


        System.out.println(myStack.empty());

    }

}
