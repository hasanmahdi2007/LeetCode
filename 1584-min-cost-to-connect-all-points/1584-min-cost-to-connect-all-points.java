class Solution {
    public int minCostConnectPoints(int[][] points) {
        if(points.length == 1) return 0;
        boolean[] visited = new boolean[points.length];
        int counter = 0;
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        int pointind = 0;
        do{
            int[] point = points[pointind];
            visited[pointind] = true;
            for(int j = 0; j < points.length; j++){
                int[] point2 = points[j];
                int distance = Math.abs(point[0] - point2[0]) + Math.abs(point[1] - point2[1]);
                heap.offer(new int[] {distance, j});
            }
            int[] value = heap.poll();
            while(visited[value[1]]){
                if(heap.isEmpty()) break;
                value = heap.poll();
            }
            if(heap.isEmpty() && visited[value[1]]) break;
            counter += value[0];
            pointind = value[1];
        } while (!heap.isEmpty());
        return counter;
    }
}