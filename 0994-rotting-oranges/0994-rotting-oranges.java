class Solution {
    public int orangesRotting(int[][] grid) {
        int oranges = 0;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) oranges++;
                else if(grid[i][j] == 2) q.offer(new int[] {i, j});
            }
        }
        if(oranges == 0) return 0;
        int mins = 0;
        int step = q.size();
        while(!q.isEmpty()){
            int[] current = q.removeFirst();
            int i = current[0];
            int j = current[1];
            if(i != 0 && grid[i-1][j] == 1){
                q.offer(new int[] {i-1, j});
                oranges--;
                grid[i-1][j] = 2;
            }
            if(i != m-1 && grid[i+1][j] == 1){
                q.offer(new int[] {i+1, j});
                oranges--;
                grid[i+1][j] = 2;
            }
            if(j != 0 && grid[i][j-1] == 1){
                q.offer(new int[] {i, j-1});
                oranges--;
                grid[i][j-1] = 2;
            }
            if(j != n-1 && grid[i][j+1] == 1){
                q.offer(new int[] {i, j+1});
                oranges--;
                grid[i][j+1] = 2;
            }
            step--;
            if(oranges == 0){
                mins++;
                break;
            }
            if(step == 0) {
                mins++;
                step = q.size();
            }    
        }
        if(oranges == 0) return mins;
        else return -1;
    }
}



