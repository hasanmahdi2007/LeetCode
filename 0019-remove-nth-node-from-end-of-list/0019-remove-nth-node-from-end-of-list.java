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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        int size = 0;
        while(current != null) {
            size++;
            current = current.next;
        }
        current = head;
        int steps = size - n - 1;
        if(steps < 0) return head.next;
        while(steps > 0){
            current = current.next;
            steps--;
        }
        current.next = current.next.next;
        return head;
    }
}