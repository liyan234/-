package src1;


/**给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
 最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大
 （一个节点也可以是它自己的祖先）。
 */
public class BuildTreeFour {

    static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }




    /**给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
     最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大
     （一个节点也可以是它自己的祖先）。
     */

    //借助一个成员变量来访问这个的公共父母节点
    private TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        findNode(root,p,q);
        return lca;
    }

    private boolean findNode(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return false;
        }
        //后序遍历进行
        int left = findNode(root.left,p,q) ? 1 : 0;
        int right = findNode(root.right,p,q) ? 1 : 0 ;
        int mid = (root == p || root == q) ? 1 : 0;

        if(left + right + mid == 2) {
            lca = root;
        }
       /* if ( (left == 1 && right == 1 && mid == 0)
        ||(left == 1 && right == 0 && mid == 1)
        ||(left == 0 && right == 1 && mid == 1) ) {
            lca = root;
        }*/
        return (mid + left + right) > 0;
    }




    /**
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
     * 要求不能创建任何新的结点，
     * 只能调整树中结点指针的指向
     * */
    public TreeNode Convert(TreeNode pRootOfTree) {

        if(pRootOfTree == null) {
            return null;
        }

        //应该用中序遍历，搜索二叉树结果为有序的
        //left为pre，right为next

        if(pRootOfTree.left == null && pRootOfTree.right == null) {
            return pRootOfTree;
        }

        //左子树
        TreeNode left = Convert(pRootOfTree.left);
        if(left != null) {
            TreeNode leftTail = left;

            while(leftTail.right != null) {
                leftTail = leftTail.right;
            }

            leftTail.right = pRootOfTree;
            pRootOfTree.left = leftTail;
        }
        //根节点不用处理，在处理左子树时，跟节点已经和左子树的遍历的最后一个节点相连接
        //处理右子树
        TreeNode right = Convert(pRootOfTree.right);
        if(right != null) {
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }
        return left != null ? left : pRootOfTree;
    }

            /**
             * 根据一棵树的前序遍历与中序遍历构造二叉树
             *前序遍历 preorder = [3,9,20,15,7]
             * 中序遍历 inorder = [9,3,15,20,7]
             *     3
             *    / \
             *   9  20
             *     /  \
             *    15   7
             **/

            //用一个数index来确定遍历到数组perorder的那一位
            //这两个数组的长度是相等的
            //要用到辅助方法来进行遍历

    private  int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        //将index置为零时，以防有多组数据需要处理
        index = 0;

        return buildTreeTreeNode(preorder,inorder,0,inorder.length);
    }

    private TreeNode buildTreeTreeNode(int[] preorder, int[] inorder, int left, int right) {
        if(left >= right) {
            return null;
        }
        if(index >= preorder.length) {
            return null;
        }

        //先序遍历得到的数组中下标为0的数为根节点
        TreeNode node = new TreeNode(preorder[index]);
        //访问完这个index后，index要++，以便下一次继续访问下一个数
        index++;
        //找到在中序遍历中根节点的位置，以此来确定左右子树分别有哪些数
        int pos = find(inorder,left,right,node.val);
        //左子树递归处理，
        node.left = buildTreeTreeNode(preorder,inorder,left,pos);
        //右子树递归处理,pos+1 非常重要。
        node.right = buildTreeTreeNode(preorder,inorder,pos+1,right);

        return node;

    }

    private int find(int[] inorder, int left, int right, int val) {
        for (int i = left; i < right; i++) {
            if ( inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }



}
