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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        helper(root, arr, 0);
        return arr;
    }

    public void helper(TreeNode current, List<Integer> arr, int h){
        if(current == null) return;
        if(arr.size() <= h) arr.add(current.val);
        helper(current.right, arr, h+1);
        helper(current.left, arr, h+1);
    }
}