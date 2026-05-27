/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> s = new HashSet<>();
        ListNode current = head;
        while(current != null){
           s.add(current);
           if(s.contains(current.next)) return true;
           current = current.next;
        }   
        return false;
    }
}