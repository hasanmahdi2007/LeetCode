class Solution {

    
    public int[][] kClosest(int[][] points, int k) {
        int[][] answer = new int[k][2];
        PriorityQueue<int[]> heap = new PriorityQueue<>(k, (a,b) -> Integer.compare(b[0], a[0]));
        for(int i = 0; i < points.length; i++){
            int distance = distance(points[i]);
            if(heap.size() == k){
                if(distance < heap.peek()[0]){
                    heap.poll();
                    heap.add(new int[] {distance, i});
                }
            } else heap.add(new int[] {distance, i});
        }
        for(int i = 0; i < k; i++) answer[i] = points[heap.poll()[1]];
        return answer;
    }

    public int distance(int[] point){
        int x = point[0];
        int y = point[1];
        return x * x + y * y;
    }
}