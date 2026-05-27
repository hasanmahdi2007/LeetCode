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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) return null;
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode last = null;
        ListNode head = null;
        if(list1.val > list2.val) head = list2;
        else head = list1;
        while(list2 != null && list1 != null){
            if(list1.val > list2.val) {
                if(last != null) last.next = list2;
                last = list2;
                list2 = list2.next;
            }   
            else {
                if(last != null) last.next = list1;
                last = list1;
                list1 = list1.next;
            }    
        }

        while(list1 != null) {
            if(last != null) last.next = list1;
            last = list1;
            list1 = list1.next;
        }
        while(list2 != null) {
            if(last != null) last.next = list2;
            last = list2;
            list2 = list2.next;
        }
        return head;
    }
}