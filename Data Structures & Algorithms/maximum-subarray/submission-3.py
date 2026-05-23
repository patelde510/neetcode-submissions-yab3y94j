class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        # curMax = nums[0]
        # curSum = 0

        # for num in nums:
        #     if curSum < 0:
        #         curSum = 0

        #     curSum += num
        #     curMax = max(curSum, curMax)
        
        # return curMax

        curMax = nums[0]
        curSum = 0

        l = 0

        for r in range(len(nums)):
            if curSum < 0:
                l = r
                curSum = 0
            
            curSum += nums[r]
            curMax = max(curMax, curSum)

        return curMax