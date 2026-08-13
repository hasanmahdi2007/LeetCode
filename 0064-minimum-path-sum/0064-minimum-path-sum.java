class Solution {
    public int minPathSum(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            Arrays.fill(memo[i], -1);
        }
        return dp(memo, grid, 0, 0);
    }

    public int dp(int[][] memo, int[][] grid, int i , int j){
        if(i == grid.length || j == grid[0].length) return Integer.MAX_VALUE;
        if (i == grid.length - 1 && j == grid[0].length - 1) return grid[i][j];
        if(memo[i][j] != -1) return memo[i][j];
        int right = dp(memo, grid, i, j+1);
        int down = dp(memo, grid, i+1, j);
        return memo[i][j] = Math.min(right, down) + grid[i][j];
    }
}