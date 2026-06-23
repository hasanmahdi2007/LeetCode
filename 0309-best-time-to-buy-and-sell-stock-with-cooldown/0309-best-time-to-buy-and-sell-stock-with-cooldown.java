class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        return dfs(prices, dp, 0, 0);
    }

    public int dfs(int[] prices, int[][] memo, int i, int hasStock){
        if(i >= prices.length) return 0;
        if(memo[i][hasStock] != 0) return memo[i][hasStock];
        int sell = 0;
        int buy = 0;
        int skip = dfs(prices, memo, i+1, hasStock);
        if(hasStock == 1) {
            sell = prices[i] + dfs(prices, memo, i+2, 0);
        }
        else{
            buy = dfs(prices, memo, i+1, 1) - prices[i];
        }
        return memo[i][hasStock] = Math.max(sell, Math.max(buy,skip));
    }
}