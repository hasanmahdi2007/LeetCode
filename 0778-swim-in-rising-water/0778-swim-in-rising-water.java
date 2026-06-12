class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid[0].length;
        int m = grid.length;
        int[][] bestTime = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                bestTime[i][j] = Integer.MAX_VALUE;
            }
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> Integer.compare(a[2], b[2]));
        heap.offer(new int[] {0,0,grid[0][0]});
        while(true){
            int[] coordinates = heap.poll();
            int i = coordinates[0];
            int j = coordinates[1];
            if(bestTime[i][j] <= coordinates[2]) continue;
            bestTime[i][j] = coordinates[2];
            int minTime = 0;
            if(i == m-1 && j == n-1) return coordinates[2];
            if(i != m-1) {
                minTime = Math.max(coordinates[2], grid[i+1][j]);
                heap.offer(new int[] {i+1, j, minTime});
            }    
            if(i != 0) {
                minTime = Math.max(coordinates[2], grid[i-1][j]);
                heap.offer(new int[] {i-1, j, minTime});
            }    
            if(j != n-1) {
                minTime = Math.max(coordinates[2], grid[i][j+1]);
                heap.offer(new int[] {i, j+1, minTime});
            }   
            if(j != 0) {
                minTime = Math.max(coordinates[2], grid[i][j-1]);
                heap.offer(new int[] {i, j-1, minTime});
            }    
        }
    }
}