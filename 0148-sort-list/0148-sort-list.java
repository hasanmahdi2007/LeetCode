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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        return merge(left, right);
    }

    public ListNode merge(ListNode head1, ListNode head2){
        ListNode base = new ListNode();
        ListNode dummy = base;
        ListNode p1 = head1;
        ListNode p2 = head2;
        while(p1 != null && p2 != null){
            if(p1.val <= p2.val){
                dummy.next = p1;
                p1 = p1.next;
                dummy = dummy.next;
            } else {
                dummy.next = p2;
                p2 = p2.next;
                dummy = dummy.next;
            }
        }
        if(p1 != null) dummy.next = p1;
        if(p2 != null) dummy.next = p2;
        return base.next;
    }
}