class MedianFinder {
    PriorityQueue<Integer> heap1;
    PriorityQueue<Integer> heap2;
    int n;
    public MedianFinder() {
        heap1 = new PriorityQueue<>(Collections.reverseOrder());
        heap2 = new PriorityQueue<>();
        n = 0;
    }
    
    public void addNum(int num) {
        if(n == 0) {
            heap1.offer(num);
            n++;
            return;
        }
        if(num < heap1.peek()) heap1.offer(num);
        else heap2.offer(num);
        if(heap1.size() - heap2.size() == 2) heap2.offer(heap1.poll());
        if(heap2.size() - heap1.size() == 2) heap1.offer(heap2.poll());
        n++;
    }
    
    public double findMedian() {
        if(n % 2 == 0){
            return (heap1.peek() + heap2.peek()) / 2.0;
        }
        else{
            if(heap1.size() > heap2.size()) return heap1.peek();
            else return heap2.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */