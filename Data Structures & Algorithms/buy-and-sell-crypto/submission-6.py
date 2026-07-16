class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0

        # Left pointer
        buy = prices[0]

        # Price is right pointer
        for price in prices:
            if price-buy > profit:
                profit = price-buy
            buy = min(buy, price)
        
        return profit