package src1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BuildTreeTwo {

    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 请你返回其按 层序遍历 得到的节点值
     * */

    public static void main(String[] args) {

    }

    private List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {

        if(root == null) {
            return result;
        }

        result.clear();

        levelOrderHelp(root,0);

        return result;
    }

    private void levelOrderHelp(TreeNode root, int level) {
       if(level == result.size()) {
           result.add(new ArrayList<>());
       }

       List<Integer> list = result.get(level);
       list.add(root.val);

       if(root.left != null) {
           levelOrderHelp(root.left,level+1);
       }

       if(root.right != null) {
           levelOrderHelp(root.right,level+1);
       }
    }

}
