/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    StringBuilder sb = new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            sb.append(1001);
            sb.append("|");
            return sb.toString();
        }
        sb.append(root.val);
        sb.append("|");
        serialize(root.left);
        serialize(root.right);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        String[] s = data.split("\\|");
        for(int i = 0; i < s.length; i++) q.offer(Integer.parseInt(s[i]));
        return TreeBuilder(q);
    }

    public TreeNode TreeBuilder(ArrayDeque<Integer> q){
        int num = q.poll();
        if(num == 1001) return null;
        TreeNode cell = new TreeNode(num);
        cell.left = TreeBuilder(q);
        cell.right = TreeBuilder(q);
        return cell;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));