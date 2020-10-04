import java.util.ArrayList;

public class TestOne_Tree {

    static class Node {
        public char val;
        public Node left;
        public Node right;

        public Node(char val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" + val +
                    '}';
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

    //来访问节点个数
    public static int size(Node root) {
        if(root == null) {
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
     }

     //访问叶子节点个数
    public static int sizeLeaves(Node root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        return sizeLeaves(root.right) + sizeLeaves(root.left);
    }

    //求第k层的节点个数
    public static int kLeaves(Node root,int k) {
        if(root == null || k < 1) {
            return 0;
        }
        if(k == 1) {
            return 1;
        }
        return kLeaves(root.left,k-1) + kLeaves(root.right,k-1);
    }

    //看树中是否有含有这个节点,有则打印，无则为null
    public static Node findKey(Node node,char key) {
        if(node == null) {
            return null;
        }
        if(node.val == key) {
            return node;
        }
        Node result = findKey(node.left,key);
        if(result != null) {
            return result;
        }
        return findKey(node.right,key);
    }

    //用链表进行前序，中序，和后序遍历、
    public static ArrayList<Character> preOrder(Node root) {
        ArrayList<Character> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        result.add(root.val);
        result.addAll(preOrder(root.left));
        result.addAll(preOrder(root.right));
        return result;
    }
    //用链表进行前序，中序，和后序遍历、
    public static ArrayList<Character> inOrder(Node root) {
        ArrayList<Character> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.addAll(inOrder(root.left));
        result.add(root.val);
        result.addAll(inOrder(root.right));
        return result;
    }

    public static ArrayList<Character> postOrder(Node root) {
        ArrayList<Character> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        result.addAll(postOrder(root.left));
        result.addAll(postOrder(root.right));
        result.add(root.val);
        return result;
    }



    public static void main(String[] args) {
        Node root = TestOne_Tree.build();

        //preOrder(root);
        //System.out.println();
        System.out.println(size(root));
        System.out.println(sizeLeaves(root));

        System.out.println(kLeaves(root,4));

        ArrayList<Character> ret1 = preOrder(root);
        System.out.println(ret1);
        ArrayList<Character> ret2 = inOrder(root);
        System.out.println(ret2);
        ArrayList<Character> ret3 = postOrder(root);
        System.out.println(ret3);
    }
}
