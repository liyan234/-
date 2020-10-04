package src1;


import java.util.Scanner;

/**
 *编一个程序，读入用户输入的一串先序遍历字符串，
 *根据此字符串建立一个二叉树（以指针方式存储）。
 *例如如下的先序遍历字符串： ABC##DE#G##F### 其中“#”表示的是空格，
 *空格字符代表空树。建立起此二叉树以后，再对二叉树进行中序遍历，输出遍历结果。*/

public class BuildTree {

    static class TreeNode {
        public char val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }



    private static int index = 0;//借助index来进行递归

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            String line = scan.nextLine();


            //index 置为0是为了 从新输入一行新的字符
            index = 0;

            //输入的时候为中序遍历，将其中的‘#’消除，并且输入这个树中

            TreeNode root = createTreeNode(line);

            //将这个树中序遍历

            inOrderTree(root);

            System.out.println();

        }


    }

    public static TreeNode createTreeNode(String line) {
        char a = line.charAt(index);


        //当这个节点值为'#'时，这个节点为空直接返回
        if(a == '#') {
            return null;
        }

        //建立起一个值为a的节点
        TreeNode treeNode = new TreeNode(a);

        //将line中的字符向后移动一位
        index++;

        treeNode.left = createTreeNode(line);

        index++;

        treeNode.right = createTreeNode(line);

        return treeNode;


    }


    //树的中序遍历
    public static void inOrderTree(TreeNode root) {
        if(root == null) {
            return;
        }

        inOrderTree(root.left);

        System.out.print(root.val + " ");

        inOrderTree(root.right);

    }
}
