class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)
        dp = [False] * n
        dp [-1] = True

        for i in range(n-2, -1, -1):
            for j in range(i+1, i+nums[i]+1):
                if j < n and dp[j]:
                    dp[i] = True
                if dp[i]:
                    break
        
        return dp[0]
