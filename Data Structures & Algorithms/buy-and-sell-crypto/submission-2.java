class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy = prices[0];

        for (int price : prices) {
            if (price - buy > profit) {
                profit = price - buy;
            }
            buy = Math.min(buy, price);
        }
        
        return profit;
    }
}
