class Solution {
    public String longestPalindrome(String s) {
        int maxLength = 0;
        int n = s.length();
        int start = 0;
        int end = 0;
        boolean[][] dp = new boolean[n][n];
        for(int i = n-1; i >= 0; i--){
            for(int j = i+1; j < n; j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j - i <= 2) dp[i][j] = true;
                    else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if(dp[i][j]) {
                    if(j - i > maxLength){
                        maxLength = j - i;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start, end+1);
    }
}