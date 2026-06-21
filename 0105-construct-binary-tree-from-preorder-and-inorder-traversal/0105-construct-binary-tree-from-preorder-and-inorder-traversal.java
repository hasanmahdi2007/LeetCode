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
    int i = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inOrderNodes = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            inOrderNodes.put(inorder[i], i);
        }
        return divideAndConquer(0, inorder.length-1, preorder, inOrderNodes);
    }

    public TreeNode divideAndConquer(int start, int end, int[] preorder, HashMap<Integer, Integer> inOrderNodes){
        if(start > end) return null;
        int root = preorder[i++];
        int mid = inOrderNodes.get(root);
        TreeNode rootNode = new TreeNode(root);
        rootNode.left = divideAndConquer(start, mid-1, preorder, inOrderNodes);
        rootNode.right = divideAndConquer(mid+1, end, preorder, inOrderNodes);
        return rootNode;
    }
}