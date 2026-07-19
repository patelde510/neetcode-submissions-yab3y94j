class Solution:
    def climbStairs(self, n: int) -> int:
        if n <= 2:
            return n

        # dp = [0] * (n+1)
        # dp[1], dp[2] = 1, 2

        # for i in range(3, n+1):
        #     dp[i] = dp[i-1] + dp[i-2]
        
        # return dp[n]

        # 1, 2, 3, 4, 5, 6

        dp1 = 1
        dp2 = 2
        for i in range(3, n+1):
            temp = dp1 + dp2
            dp1 = dp2
            dp2 = temp
        
        return dp2




