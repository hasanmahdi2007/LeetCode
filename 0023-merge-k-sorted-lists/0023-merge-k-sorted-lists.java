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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        int n = lists.length;
        int cycles =(int) Math.ceil(Math.log(n) / Math.log(2));
        int counter = 2;
        while(cycles > 0){
            for(int i = 0; i < n; i += counter){
                if(i+counter/2 >= n) break;
                ListNode pointer1 = lists[i];
                ListNode pointer2 = lists[i + counter/2];
                if(pointer1 == null && pointer2 == null) continue;
                else if (pointer1 == null) {
                    lists[i] = pointer2;
                    continue;
                }
                else if (pointer2 == null) continue;
                ListNode last = pointer1;
                if(pointer1.val > pointer2.val){
                    lists[i] = pointer2;
                    last = pointer2;
                    pointer2 = pointer2.next;
                } else {
                    pointer1 = pointer1.next;
                }
                while(pointer2 != null && pointer1 != null){
                    if(pointer1.val > pointer2.val) {
                        last.next = pointer2;
                        last = pointer2;
                        pointer2 = pointer2.next;
                    }
                    else{
                        last.next = pointer1;
                        last = pointer1;
                        pointer1 = pointer1.next;
                    }
                }
                while(pointer1 != null) {
                    last.next = pointer1;
                    last = pointer1;
                    pointer1 = pointer1.next;
                }
                while(pointer2 != null) {
                    last.next = pointer2;
                    last = pointer2;
                    pointer2 = pointer2.next;
                }               
            }
            counter *= 2;
            cycles--;
        }
        return lists[0];
    }
}