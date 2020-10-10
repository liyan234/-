public class BinarySearchTree {

    static class TreeNode {

        public int key;
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode root;

        public TreeNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "key=" + key +
                    ", val=" + val +
                    '}';
        }
    }
    private TreeNode root = null;

    public void insert(int key,int val) {
        TreeNode node = new TreeNode(key,val);
        if (root == null) {
            root = node;
        }

        TreeNode cur = root;
        TreeNode prev = null;//前置节点

        while (cur != null) {
            if (cur.key >  node.key) {
                prev = cur;//前置节点必须放于 cur = cur.left的前面
                cur = cur.left;
            } else if (cur.key < node.key) {
                prev = cur;//同理
                cur = cur.right;
            } else {
                cur.val = node.val;
                return;
            }
        }

        if(prev.key > node.key) {
            prev.left = node;
        } else if (prev.key < node.key) {
            prev.right = node;
        }
    }

    //查找
    public TreeNode find(int key) {
        if(root.key == key) {
            return root;
        }

        TreeNode cur = root;
        while(cur != null) {
            if (cur.key > key) {
                cur = cur.left;
            } else if (cur.key < key) {
                cur = cur.right;
            } else {
                return cur;
            }
        }
        return null;
    }

    public void remove (int key) {

        TreeNode cur = root;
        TreeNode prev = null;

        while (cur != null) {
            if (key < cur.key) {
               prev = cur;
               cur = cur.left;
            } else if (key > cur.key) {
                prev = cur;
                cur = cur.right;
            } else {
                removeHelp(cur,prev);
                return;//这个return至关重要
            }
        }
    }

    private void removeHelp(TreeNode cur, TreeNode prev) {
        if (cur.left == null) {
            if (cur == root ) {
                root = cur.right;
            } else if (cur == prev.left) {
                prev.left = cur.right;
            } else if (cur == prev.right) {
                prev.right = cur.right;
            }

        } else if (cur.right == null) {
            if (cur == root ) {
                root = cur.left;
            } else if (cur == prev.left) {
                prev.left = cur.left;
            } else if (cur == prev.right) {
                prev.right = cur.left;
            }
        } else {
            TreeNode sheep = cur.left;//找左子树
            TreeNode sheepParent = cur;

            //找左子树的最大值
            //或者找右子树的最小值
            //因为上面是是找左子树，所以向右找
            while(sheep.right != null) {
                sheepParent =sheep;
                sheep = sheep.right;
            }

            cur.key = sheep.key;
            cur.val = sheep.val;

            if (sheepParent.left == sheep) {
                sheepParent.left = sheep.left;
            } else {
                sheepParent.right = sheep.left;
            }
        }
    }


    public void preOrder(TreeNode node) {
        if(node == null) {
            return;
        }
        System.out.print(node.key + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(TreeNode node) {
        if(node == null) {
            return;
        }
        preOrder(node.left);
        System.out.print(node.key + " ");
        preOrder(node.right);
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(3,30);
        tree.insert(4,40);
        tree.insert(2,20);
        tree.insert(1,10);
        tree.insert(0,0);
        tree.insert(7,70);
        tree.insert(8,80);

        tree.inOrder(tree.root);
        System.out.println();
        tree.preOrder(tree.root);
        System.out.println();

        System.out.println(tree.find(2));

        System.out.println(tree.find(9));

        tree.inOrder(tree.root);
        tree.remove(7);
        System.out.println();
        tree.inOrder(tree.root);
    }



}
