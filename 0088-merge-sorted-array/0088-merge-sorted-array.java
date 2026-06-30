class Solution {
    private class Node{
        Node next;
        int data;
        public Node(int data){
            this.data = data;
        }
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) return;
        if(m == 0){
            for(int i = 0; i < n; i++)
                nums1[i] = nums2[i];
            return;
        }
        int p1 = 0;
        int p2 = 0;
        Node current = new Node(0);
        if(nums1[p1] > nums2[p2]){
            current.data = nums2[0];
            p2++;
        }    
        else {
            current.data = nums1[0];
            p1++;
        }
        Node head = current;    
        while(p1 < m && p2 < n){
            Node next = new Node(0);
            if(nums1[p1] > nums2[p2]){
                next.data = nums2[p2];
                p2++;
            }    
            else {
                next.data = nums1[p1];
                p1++; 
            }
            current.next = next;
            current = next;
        }    

        while(p1 < m){
            current.next = new Node(nums1[p1++]);
            current = current.next;
        }

        while(p2 < n){
            current.next = new Node(nums2[p2++]);
            current = current.next;
        }
        int pointer = 0;
        for(int i = 0; i < m + n; i++){
            nums1[pointer++] = head.data;
            head = head.next;
        }
    }
}