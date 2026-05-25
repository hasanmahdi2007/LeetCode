class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max_ind = n - 1;
        int best_buy = Integer.MIN_VALUE;
        for(int i = n - 1; i >= 0; i--){
            int result = prices[max_ind] - prices[i];
            if(result > best_buy) best_buy = result; 
            if(prices[i] > prices[max_ind]) max_ind = i;
        }
        return best_buy;
    }
}