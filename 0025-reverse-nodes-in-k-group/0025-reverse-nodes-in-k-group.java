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
    public ListNode reverseKGroup(ListNode head, int k) {
        Deque<ListNode> s = new ArrayDeque<>();
        if(k == 1) return head;
        ListNode current = head;
        int n = 0;
        while(current != null) {
            current = current.next;
            n++;
        }
        ListNode newHead = null;
        current = head;
        ListNode next = null;
        int loops = 0;
        ListNode last = null;
        while(n >= k){
            n-=k;
            loops++;
            int steps = k;
            s.push(current);
            while(steps > 1) {
                current = current.next;
                if(steps != 2) s.push(current);
                else {
                    if(loops != 1) last.next = current;
                }    
                steps--;
            }
            if(loops == 1) newHead = current;
            next = current.next;
            while(!s.isEmpty()){
                current.next = s.pop();
                current = current.next;
            }
            last = current;
            current = next;
        }
        last.next = current;    
        return newHead;
    }
}