package leetcode.fia.week4;

import java.util.ArrayList;
import java.util.List;

public class LeetCode226 {
    public TreeNode invertTree(TreeNode root) {
        List<TreeNode> prevDepth = new ArrayList<>();
        prevDepth.add(root);
        List<TreeNode> currentDepth = new ArrayList<>();
        currentDepth.add(root);

        TreeNode left;
        TreeNode right;

        while (currentDepth.size() != 0) {
            for (int i = 0; i < currentDepth.size(); i++) {
                TreeNode currentRoot = currentDepth.get(i);
                if (currentRoot.left != null) {
                    left = currentRoot.left;
                } else {
                    left = null;
                }
                if (currentRoot.right != null) {
                    right = currentRoot.right;
                } else {
                    right = null;
                }
                currentRoot.left = right;
                currentRoot.right = left;
            }
            prevDepth = currentDepth;
            for (int i = 0; i < prevDepth.size(); i++) {
                currentDepth = new ArrayList<>();
                if (prevDepth.get(i).left != null) {
                    currentDepth.add(prevDepth.get(i).left);
                }
                if (prevDepth.get(i).right != null) {
                    currentDepth.add(prevDepth.get(i).right);
                }
            }
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