package leetcode.ayaan.week4;

public class InvertBinaryTree_ayaan {
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(9);
        TreeNode node1 = new TreeNode(2, node3, node4);
        TreeNode node2 = new TreeNode(7, node5, node6);
        TreeNode root = new TreeNode(4, node1, node2);

        TreeNode result = invertTree(root);
        System.out.println(result);
    }

    public static TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }

        // 이해는 되는데 이걸 어떻게 생각해내지...
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;

        return root;
    }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }