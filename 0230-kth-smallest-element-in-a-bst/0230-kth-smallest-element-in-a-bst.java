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

    int counter;
    public int kthSmallest(TreeNode root, int k) {
        int[] a = new int[] {k};
        return helper(root, a);
    }

    public int helper(TreeNode current, int[] a){
        if(current == null) return -1;
        int left = helper(current.left, a);
        if(left != -1) return left;
        a[0]--;
        if(a[0] == 0) return current.val;
        return helper(current.right, a);
    }
}