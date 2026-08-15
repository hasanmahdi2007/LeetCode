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
    public TreeNode sortedArrayToBST(int[] nums) {
        return divideAndConquer(nums, 0, nums.length-1);
    }

    public TreeNode divideAndConquer(int[] nums, int start, int end){
        if(start > end) return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = divideAndConquer(nums, start, mid-1);
        root.right = divideAndConquer(nums, mid+1, end);
        return root;
    }
}