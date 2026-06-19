class Solution {
    public int[] countBits(int n){
        int[] dp = new int[n+1];
        int power = 1;
        for(int i = 1; i < dp.length; i++){
            if(power * 2 == i) 
                power = i;
            dp[i] = 1 + dp[i-power];
        }
        return dp;
    }
}