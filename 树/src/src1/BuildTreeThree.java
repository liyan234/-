package src1;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断完全二叉树*/
public class BuildTreeThree {

    static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


   public static boolean isCompleteTree(TreeNode root) {

        if(root == null) {
            return true;
        }

        //置一个变量，来控制下面的循环
        boolean A = true;

        //用队列来进行层序遍历
       Queue<TreeNode> queue = new LinkedList<>();
       queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (A) {
                if (root.left == null && root.right == null) {
                    //左右子树都为空，
                    return true;
                } else if (root.left != null && root.right == null) {
                    //左子树不为空，右子树为空，将A置为false，然后下来判断这个左子树是否还有子树
                    queue.offer(root.left);
                    A = false;
                } else if (root.left == null && root.right != null) {
                    //左子树为空，右子树不为空，不是完全二叉树，直接返回
                    return false;
                } else {
                    //左右子树都不为空，加入队列中，再开始判断
                    //先让左子树进入队列，然后右子树进入队列，不能相反
                    queue.offer(root.left);
                    queue.offer(root.right);
                }
            } else {
                if(cur.left == null && cur.right == null) {
                    return true;
                }
            }
        }
        return false;
    }

}
