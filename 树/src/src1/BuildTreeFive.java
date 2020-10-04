package src1;

public class BuildTreeFive {

    static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }



    StringBuilder str = new StringBuilder();
    public String tree2str(TreeNode t) {

        if (t == null) {
            return "";
        }

        helpBuild(t);

        str.deleteCharAt(str.length() - 1);
        str.deleteCharAt(0);
        return String.valueOf(str);
    }

    private void helpBuild(TreeNode t) {

        if (t == null) {
            return;
        }

        str.append("(");
        str.append(t.val);

        helpBuild(t.left);
        if(t.left == null && t.right != null) {
            str.append("()");
        }

        helpBuild(t.right);
        str.append(")");
    }


    /**
     *根据一棵树的中序遍历与后序遍历构造二叉树
     * 中序遍历 inorder = [9,3,15,20,7]
     * 后序遍历 postorder = [9,15,7,20,3]
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * */

    private  int index = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = postorder.length-1;
        return helpBuildTree(inorder,postorder,0,inorder.length);
    }

    private TreeNode helpBuildTree(int[] inorder, int[] postorder, int left, int right) {

        if(left >= right) {
            return null;
        }
        if(index < 0) {
            return null;
        }

        TreeNode newNode = new TreeNode(postorder[index]);
        index--;

        int pos = findVal(inorder,left,right,newNode.val);

        newNode.right = helpBuildTree(inorder,postorder,pos+1,right);

        newNode.left = helpBuildTree(inorder,postorder,left,pos);



        return newNode;
    }

    private int findVal(int[] inorder,int left,int right, int val) {
        for (int i = left; i < right ; i++) {
            if(inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }


}


