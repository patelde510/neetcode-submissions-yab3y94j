class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        total = 0
        realTotal = 0
        for i in range(1, len(nums)+1):
            total += i
            realTotal += nums[i-1]
        
        return total-realTotal