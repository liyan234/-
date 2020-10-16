import java.util.Stack;


//获取栈中最小元素的时候，时间复杂度为O(1);
public class MinStack {
    // A 中是按照正常的栈来存储元素
    Stack<Integer> A = new Stack<>();
    // B 中每个元素都是 A 中对应元素个数情况下的最小值
    Stack<Integer> B = new Stack<>();
    // A 和 B 中的元素要同步变化.

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        if(A.isEmpty() && B.isEmpty()) {
            A.push(x);
            B.push(x);
            return;
        }
        A.push(x);
        int tmp = B.peek();
        if(tmp < x) {
            x = tmp;
        }
        B.push(x);
    }

    public Integer pop() {
        if(A.isEmpty()) {
            return null;
        }
        B.pop();
        return A.pop();
    }

    public Integer top() {
        if(A.isEmpty()) {
            return null;
        }
        return A.peek();
    }

    public Integer getMin() {
        if(A.isEmpty()) {
            return null;
        }
        return B.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(5);
        minStack.push(6);
        minStack.push(3);
        minStack.push(4);
        minStack.push(6);
        minStack.push(5);

        System.out.println(minStack.getMin());
        System.out.println();
        System.out.println(minStack.pop());
        System.out.println(minStack.pop());
        System.out.println(minStack.pop());
        System.out.println(minStack.pop());
        System.out.println();
        System.out.println(minStack.getMin());;


    }
}
