/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        Deque<ListNode> q = new ArrayDeque<>();
        ListNode current = head;
        while(current != null){
            q.offer(current);
            current = current.next;
        }
        current = head;
        q.removeFirst();
        while(!q.isEmpty()){
            current.next = q.removeLast();
            current = current.next;
            if(q.isEmpty()) {
                current.next = null;
                return;
            }    
            current.next = q.removeFirst();
            current = current.next;
        }
        current.next = null;
    }
}