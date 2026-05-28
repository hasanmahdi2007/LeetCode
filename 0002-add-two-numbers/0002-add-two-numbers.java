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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> s = new ArrayDeque<>();
        int digit_counter = 0;
        int carry = 0;
        ListNode head = l1;
        ListNode prev = head;
        int sum = l1.val + l2.val + carry;
        if(sum > 9) {
            sum -= 10;
            carry = 1;
        }
        head.val = sum;
        l2 = l2.next;
        l1 = l1.next;
        ListNode tracker = head;    

        while(l1 != null && l2 != null){
            sum = l1.val + l2.val + carry;
            if(sum > 9) {
                sum -= 10;
                carry = 1;
            } else carry = 0;
            l1.val = sum;
            tracker = l1;
            prev.next = l1;
            prev = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null) {
            sum = l1.val + carry;
            if(sum > 9) {
                sum -= 10;
                carry = 1;
            } else carry = 0;
            l1.val = sum;
            tracker = l1;
            prev.next = l1;
            prev = l1;
            l1 = l1.next;
        }    
        while(l2 != null) {
            sum = l2.val + carry;
            if(sum > 9) {
                sum -= 10;
                carry = 1;
            } else carry = 0;
            l2.val = sum;
            tracker = l2;
            prev.next = l2;
            prev = l2;
            l2 = l2.next;
        }
        if(carry == 1) tracker.next = new ListNode(1);    
        return head;
    }
}