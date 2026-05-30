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
    public int goodNodes(TreeNode root) {
        counter = 0;
        helper(root, root.val);
        return counter;
    }

    public void helper(TreeNode root, int max){
        if(root == null) return;
        if(root.val >= max) {
            max = root.val;
            counter++;
        }
        helper(root.left,max);
        helper(root.right,max);
    }
}