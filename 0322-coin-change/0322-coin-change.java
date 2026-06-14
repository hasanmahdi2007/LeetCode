class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        for(int i = 1; i <= amount; i++){
            for(int coin : coins){
                if(coin == i) {
                    dp[i] = 1;
                    break;
                }
                if(coin < i){
                    if(dp[i - coin] + 1 < dp[i]) dp[i] = dp[i - coin] + 1;
                }
            }
        }
        if(dp[amount] == amount+1) return -1;
        return dp[amount];
    }
}