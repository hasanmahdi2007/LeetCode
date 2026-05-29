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

    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        helper1(root);
        return maxDiameter;
    }

    public int helper1(TreeNode current){
        if(current == null) return 0;
        int leftH = helper1(current.left);
        int rightH = helper1(current.right);
        int height = Math.max(rightH, leftH) + 1;
        int diameter = leftH + rightH; 
        maxDiameter = Math.max(diameter, maxDiameter);
        return height;
    }
}