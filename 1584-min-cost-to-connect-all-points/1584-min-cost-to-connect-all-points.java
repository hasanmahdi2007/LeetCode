class Solution {
    public int minCostConnectPoints(int[][] points) {
        if(points.length == 1) return 0;
        boolean[] visited = new boolean[points.length];
        int counter = 0;
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        heap.offer(new int[] {0,0});
        while (!heap.isEmpty()){
            int[] value = heap.poll();
            int[] point = points[value[1]];
            if(visited[value[1]]) continue;
            visited[value[1]] = true;
            for(int j = 0; j < points.length; j++){
                if(visited[j]) continue;
                int[] point2 = points[j];
                int distance = Math.abs(point[0] - point2[0]) + Math.abs(point[1] - point2[1]);
                heap.offer(new int[] {distance, j});
            }
            counter += value[0];
        } 
        return counter;
    }
}