class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        int bool = dfs(0, 0, 0, dp, s1, s2, s3);
        if(bool == 1) return true;
        return false;
    }

    public int dfs(int i, int j, int k, int[][] dp, String s1, String s2, String s3){
        if(k == s3.length()) return 1;
        if(dp[i][j] != 0) return dp[i][j];
        int one = 2;
        int two = 2;
        if(i < s1.length() && s3.charAt(k) == s1.charAt(i)) one = dfs(i+1, j, k+1, dp, s1, s2, s3);
        if(j < s2.length() && s3.charAt(k) == s2.charAt(j)) two = dfs(i, j+1, k+1, dp, s1, s2, s3);
        dp[i][j] = Math.min(one, two);
        return dp[i][j];
    }
}