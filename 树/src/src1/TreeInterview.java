package src1;

public class TreeInterview {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }



    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }

        if(p == null || q == null) {
            return false;
        }

        return (p.val == q.val) && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }


    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null) {
            return false;
        }

        if(isSameTree(s,t)) {
            return true;
        }

        return isSubtree(s.left,t) || isSubtree(s.right,t);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return 1 +   (Math.max(left, right));
    }

    public boolean isBalanced(TreeNode root) {

        if(root == null) {
            return true;
        }

        if(root.right == null && root.left == null) {
            return true;
        }

        int ret = maxDepth(root.right) - maxDepth(root.left);

        return (ret >= -1 && ret <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }

    //对称二叉树

    public boolean isSymmetric(TreeNode root) {

        if(root == null) {
            return true;
        }

        if(root.left == null && root.right == null) {
            return true;
        }

        return isSame(root.right,root.left);
    }
    public boolean isSame(TreeNode A,TreeNode B) {

        if(A == null && B == null) {
            return true;
        }
        if(A == null || B == null) {
            return false;
        }

        return (A.val == B.val) && isSame(A.left,B.right) && isSame(A.right,B.left);
    }

   /**
    *编一个程序，读入用户输入的一串先序遍历字符串，
    *根据此字符串建立一个二叉树（以指针方式存储）。
    *例如如下的先序遍历字符串： ABC##DE#G##F### 其中“#”表示的是空格，
    *空格字符代表空树。建立起此二叉树以后，再对二叉树进行中序遍历，输出遍历结果。*/





}
