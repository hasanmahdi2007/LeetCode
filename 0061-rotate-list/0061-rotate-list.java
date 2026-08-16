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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode curr = head;
        if(curr == null) return null;
        int size = 1;
        while(curr.next != null){
            curr = curr.next;
            size++;
        }
        int leftSpots = k % size;
        int steps = size - (leftSpots+1);
        ListNode curr2 = head;
        for(int i = 0; i < steps; i++){
            curr2 = curr2.next;
        }
        ListNode newHead = null;
        if(curr != curr2) newHead = curr2.next;
        else newHead = head;
        curr.next = head;
        curr2.next = null;
        return newHead;
    }
}