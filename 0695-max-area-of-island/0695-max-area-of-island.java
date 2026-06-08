class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int max_area = 0;
        int[] area_counter = new int[] {0};
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    area_counter[0] = 0;
                    island_area(grid, i, j, area_counter);
                    if(area_counter[0] > max_area) max_area = area_counter[0];
                }
            }
        }
        return max_area;
    }

    public void island_area(int[][] grid, int i , int j, int[] area_counter){
        if(i == -1 || j == -1 || i == grid.length || j == grid[0].length)
            return;
        if(grid[i][j] == 0) 
            return;
        grid[i][j] = 0;
        area_counter[0]++;
        island_area(grid, i+1, j, area_counter);
        island_area(grid, i-1, j, area_counter);
        island_area(grid, i, j+1, area_counter);
        island_area(grid, i, j-1, area_counter);
    }
}