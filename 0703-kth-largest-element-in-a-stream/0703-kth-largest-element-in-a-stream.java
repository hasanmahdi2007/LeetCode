class KthLargest {
    PriorityQueue<Integer> heap;
    int k;
    public KthLargest(int k, int[] nums) {
        heap = new PriorityQueue<>(k);
        this.k = k;
        for(int num: nums) {
            if(heap.size() == k) {
                if(num > heap.peek()){
                    heap.poll();
                    heap.add(num);
                }    
            }
            else heap.add(num);    
        }        
    }
    
    public int add(int val) {
        if(heap.size() == k) {
                if(val > heap.peek()){
                    heap.poll();
                    heap.add(val);
                }    
            }
            else heap.add(val);   
        return heap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */