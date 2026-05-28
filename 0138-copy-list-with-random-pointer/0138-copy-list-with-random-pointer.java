/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node,Node> m = new HashMap<>();
        Node copy = new Node(head.val);
        m.put(copy,head);
        m.put(head,copy);
        Node head2 =  helper(head.next, copy, copy, m);
        Node current = head2;
        while(current != null){
            current.random = m.get(m.get(current).random);
            current = current.next;
        }
        return head2;
    }


    public Node helper(Node current, Node prev_copy, Node head, Map<Node,Node> m){
        if(current == null) {
            prev_copy.next = null;
            return head;
        }
        Node copy = new Node(current.val);
        m.put(copy,current);
        m.put(current,copy);
        prev_copy.next = copy;
        return helper(current.next, copy, head, m);
    }

}