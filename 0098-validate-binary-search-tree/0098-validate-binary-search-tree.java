/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root.left, Long.MIN_VALUE, root.val) && helper(root.right, root.val, Long.MAX_VALUE);
    }

    public boolean helper(TreeNode root, long leftBound, long rightBound){
        if(root == null) return true;
        if(root.val <= leftBound || root.val >= rightBound) return false;
        return helper(root.left, leftBound, root.val) && helper(root.right, root.val, rightBound);
    }
}