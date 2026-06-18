class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] memo = new int[n][m];
        for(int i = 0; i < n; i++)
            Arrays.fill(memo[i], -1);
        return dfs(0, 0, s, t, memo);
    }

    public int dfs(int i, int j, String s, String t, int[][] dp){
        if(j == t.length()) return 1;
        if(i == s.length()) return 0;
        if(dp[i][j] != -1) return dp[i][j]; 
        if(s.charAt(i) != t.charAt(j)){
            return dp[i][j] = dfs(i+1, j, s, t, dp);
        }
        int took = dfs(i+1, j+1, s, t, dp);
        int leave = dfs(i+1, j, s, t, dp);
        return dp[i][j] = took + leave;
    } 
}