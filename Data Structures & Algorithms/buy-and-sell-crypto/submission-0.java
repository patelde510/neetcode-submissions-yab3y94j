class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minBuy = prices[0];

        for (int sellPrice : prices) {
            profit = Math.max(profit, sellPrice - minBuy);
            minBuy = Math.min(minBuy, sellPrice);
        }

        return profit;        
    }
}
