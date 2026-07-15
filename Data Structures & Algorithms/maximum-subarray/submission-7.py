class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        curSum = 0
        curMax = nums[0]

        for n in nums:
            if curSum < 0:
                curSum = 0
            curSum += n
            curMax = max(curMax, curSum)

        return curMax
