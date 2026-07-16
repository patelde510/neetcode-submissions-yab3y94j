class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        maxProfit = 0
        buy = prices[0]

        for price in prices:
            if (price-buy) > maxProfit:
                maxProfit = price-buy
            buy = min(buy, price)

        return maxProfit