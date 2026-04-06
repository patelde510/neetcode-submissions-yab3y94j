class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int maxProfit = 0;
        int buy = prices[0];

        for (int num : prices) {
            maxProfit = max(maxProfit, num - buy);
            if (num < buy) {
                buy = num;
            }
        }

        return maxProfit;
    }
};
