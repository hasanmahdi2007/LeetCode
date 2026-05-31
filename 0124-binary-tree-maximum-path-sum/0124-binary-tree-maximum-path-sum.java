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
    private int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        helper(root);
        return max;
    }
    public int helper(TreeNode root) {
        if(root == null) return 0;
        int maxPotentialLeft = helper(root.left);
        int maxPotentialRight = helper(root.right);
        int sum = root.val;
        if(maxPotentialLeft > 0 || maxPotentialRight > 0) sum += Math.max(maxPotentialRight, maxPotentialLeft);
        int sum_all = root.val;
        if(maxPotentialLeft > 0) sum_all += maxPotentialLeft;
        if(maxPotentialRight > 0) sum_all += maxPotentialRight;
        max = Math.max(max, sum_all);
        return sum;
    }
}