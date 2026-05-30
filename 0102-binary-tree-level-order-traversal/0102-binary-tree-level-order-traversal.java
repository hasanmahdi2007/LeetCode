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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        List<List<Integer>> L = new ArrayList<>();
        if(root == null) return L;
        q.offer(root);
        int counter = 1;
        int nextcounter = 0;
        List<Integer> InnerL = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode current = q.removeFirst();
            if (counter == 0){
                L.add(InnerL);
                InnerL = new ArrayList<>();
                counter = nextcounter;
                nextcounter = 0;
            }
            if(current.left != null) {
                q.offer(current.left);
                nextcounter++;
            }        
            if(current.right != null){
                q.offer(current.right);
                nextcounter++;
            } 
            InnerL.add(current.val);
            counter--;
        }
        L.add(InnerL);
        return L;
    }
}