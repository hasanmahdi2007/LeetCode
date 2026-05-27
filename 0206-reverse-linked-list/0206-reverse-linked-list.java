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
    public ListNode reverseList(ListNode head) {
        return helper1(head, null);
    }

    public ListNode helper1(ListNode current, ListNode previous){
        if(current == null) return previous;
        ListNode next = current.next;
        current.next = previous;
        return helper1(next, current);
    }
}