class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dfs(text1.length()-1, text2.length()-1, text1, text2, dp);
    }

    public int dfs(int i, int j, String text1, String text2, int[][] dp){
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(text1.charAt(i) == text2.charAt(j)) {
            dp[i][j] = 1 + dfs(i-1, j-1, text1, text2, dp);
        }
        else {
            dp[i][j] = Math.max(dfs(i-1, j, text1, text2, dp), dfs(i, j-1, text1, text2, dp));
        }
        return dp[i][j];    
    }
}