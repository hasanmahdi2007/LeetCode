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
        int pointer1 = 0;
        int pointer2 = 0;
        ArrayList<ListNode> arr = new ArrayList<>();
        if(list1 == null && list2 == null) return null;
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        while(list2 != null && list1 != null){
            if(list1.val > list2.val) {
                if(arr.size() != 0) arr.get(arr.size()-1).next = list2;
                arr.add(list2);
                list2 = list2.next;
            }   
            else {
                if(arr.size() != 0) arr.get(arr.size()-1).next = list1;
                arr.add(list1);
                list1 = list1.next;
            }    
        }

        while(list1 != null) {
            if(arr.size() != 0) arr.get(arr.size()-1).next = list1;
            arr.add(list1);
            list1 = list1.next;
        }
        while(list2 != null) {
            if(arr.size() != 0) arr.get(arr.size()-1).next = list2;
            arr.add(list2);
            list2 = list2.next;
        }
        return arr.get(0);
    }
}