class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        int max = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int length = dfs(i, j, dp, matrix, visited, -1);
                max = Math.max(max, length);
            }
        }
        return max;
    }

    public int dfs(int i, int j, int[][] dp, int[][] matrix, boolean visited[][], int last){
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || visited[i][j]) 
        return 0;
        if(matrix[i][j] <= last) return 0;
        if(dp[i][j] != 0) return dp[i][j];
        visited[i][j] = true;
        int left = dfs(i, j-1, dp, matrix, visited, matrix[i][j]);
        int right = dfs(i, j+1, dp, matrix, visited, matrix[i][j]);
        int up = dfs(i-1, j, dp, matrix, visited, matrix[i][j]);
        int down = dfs(i+1, j, dp, matrix, visited, matrix[i][j]);
        dp[i][j] = Math.max(Math.max(Math.max(down, up), left), right) + 1;
        visited[i][j] = false;
        return dp[i][j];
    }
}