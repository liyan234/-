import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;

public class Test_Tree {

    static class Node {
        public char val;
        public Node left;
        public Node right;

        public Node(char val) {
            this.val = val;
        }
    }

    static Node build() {
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        Node H = new Node('H');
        Node I = new Node('I');

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        D.left = G;
        D.right = H;
        C.left = F;
        F.right = I;

        return A;
    }

    public static void preOrder(Node node) {
        if(node == null) {
            return;
        }

        System.out.print(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);

    }

    public static void cenOrder(Node node) {
        if(node == null) {
            return;
        }
        cenOrder(node.left);
        System.out.print(node.val + " ");
        cenOrder(node.right);
    }

    public static void epilogueOrder(Node node) {
        if (node == null) {
            return;
        }
        epilogueOrder(node.left);
        epilogueOrder(node.right);
        System.out.print(node.val + " ");;
    }

    //层序遍历
    public static void levelOrder(Node root) {
        if(root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()) {
            Node cur = queue.poll();

            System.out.print(cur.val + " ");

            if(cur.left != null) {
                queue.offer(cur.left);
            }
            if(cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }
    public static List<List<Character>> levelOrderT(Node root) {

        List<Node> list1 = new LinkedList<>();
        List<List<Character>> list3 = new LinkedList<>();
        if(root == null) {
            return null;
        }
        list1.add(root);

        while(!list1.isEmpty()) {

            List<Character> list2 = new LinkedList<>();
            Node cur = list1.remove(0);
            list2.add(cur.val);

            if(cur.left != null) {
                list1.add(cur.left);
            }

            if(cur.right != null) {
                list1.add(cur.right);
            }
            list3.add(list2);
        }

        return list3;
    }




    public static void main(String[] args) {
        Node root = build();
        preOrder(root);
        System.out.println();
        cenOrder(root);
        System.out.println();
        epilogueOrder(root);

        System.out.println();

        System.out.println();
    }
}
