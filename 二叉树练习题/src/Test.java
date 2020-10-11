import java.util.LinkedList;
import java.util.Queue;

public class Test {

    public class TreeNode {
          public   int val;
          public TreeNode left;
          public TreeNode right;
          TreeNode(int x) { val = x; }
    }


    /**
     * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。
     * 树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
     * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
     *
     *
     *            1
     *          /   \
     *         3     2
     *        / \     \
     *       5   3     9
     *
     * 输出: 4
     * 解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)
     *
                 1
               /
              3
             / \
            5   3

     输出: 2
     解释: 最大值出现在树的第 3 层，宽度为 2 (5,3).

                1
               / \
              3   2
             /     \
            5       9
           /         \
          6           7
             输出: 8
     解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。

     * */


    //层序遍历，将每一个节点的下标储存在一个链表中
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();

        queue.add(root);
        list.add(1);

        while (!queue.isEmpty()) {
            int count = queue.size();

            for (int i = count; i > 0; i--) {

                TreeNode cur = queue.poll();
                Integer index = list.removeFirst();

                if (cur.left != null) {
                    queue.add(cur.left);
                    list.add(index * 2);
                }

                if (cur.right != null) {
                    queue.add(cur.right);
                    list.add((index * 2) + 1);
                }
            }
        }

        return 0;
    }
}
