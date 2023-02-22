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
        TreeNode left = root.left;
        TreeNode right = root.right;

        if(root == null){
            return root;
        }

        TreeNode temp;
        temp = left;
        root.left = right;
        root.right = temp;

        while(true){
            TreeNode left_left = root.left.left;
            TreeNode left_right = root.left.right;
            if(left_left == null && left_right == null){
                break;
            }
            left = invertTree(left);
        }

        while(true){
            TreeNode right_left = root.right.left;
            TreeNode right_right = root.right.right;
            if(right_left == null && right_right == null){
                break;
            }
            right = invertTree(right);
        }

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