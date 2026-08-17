class Solution {
    public int maxProfit(int[] prices) {
        int[][][] memo = new int[2][3][prices.length];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        int ans = dp(prices, memo, 0, 0, 0);
        return ans;
    }

    public int dp(int[] prices, int[][][] memo, int havingStock, int transactions, int day){
        if (day == prices.length || transactions == 2) return 0;
        if (memo[havingStock][transactions][day] != -1) return memo[havingStock][transactions][day];
        int buy = 0;
        int sell = 0;
        int skip = dp(prices, memo, havingStock, transactions, day+1);
        if(havingStock == 0) buy = - prices[day] + dp(prices, memo, 1, transactions, day+1);
        if(havingStock == 1) sell = prices[day] + dp(prices, memo, 0, transactions + 1, day+1);
        return memo[havingStock][transactions][day] = Math.max(skip, Math.max(buy, sell));
    }
}