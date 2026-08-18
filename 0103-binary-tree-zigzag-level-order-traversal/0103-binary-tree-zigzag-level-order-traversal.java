class Solution {
    public class Node {
        Node next;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        boolean rightToLeft = false;
        while (!q.isEmpty()) {
            int size = q.size();
            Node dummy = new Node(-1);
            Node tail = dummy;
            for (int i = 0; i < size; i++) {
                TreeNode current = q.poll();
                if (rightToLeft) {
                    Node newNode = new Node(current.val);
                    newNode.next = dummy.next;
                    dummy.next = newNode;
                } else {
                    tail.next = new Node(current.val);
                    tail = tail.next;
                }

                if (current.left != null) {
                    q.offer(current.left);
                }
                if (current.right != null) {
                    q.offer(current.right);
                }
            }
            List<Integer> a = new ArrayList<>();
            Node cur = dummy.next;
            while (cur != null) {
                a.add(cur.val);
                cur = cur.next;
            }
            ans.add(a);
            rightToLeft = !rightToLeft;
        }
        return ans;
    }
}