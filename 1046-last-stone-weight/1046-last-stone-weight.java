class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones) heap.add(stone);
        while(heap.size() > 1){
            int stone1 = heap.poll();
            int stone2 = heap.poll();
            if(stone1 - stone2 != 0) heap.add(stone1 - stone2);
        }
        if(heap.size() == 0) return 0;
        return heap.peek();
    }
}