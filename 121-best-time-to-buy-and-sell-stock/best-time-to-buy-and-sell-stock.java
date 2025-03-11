class Solution {
    public int maxProfit(int[] prices) {
        int costPrice = prices[0];
        prices[0] = 0;
        int profit = 0;

        for(int i = 1; i < prices.length; i++){
            if(costPrice > prices[i]){
                costPrice = prices[i];
                prices[i] = 0;
            } else {
                profit = Math.max(profit, prices[i] - costPrice);
            }
        }
        return profit;
    }
}