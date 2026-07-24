class Solution:
    def rob(self, nums: List[int]) -> int:
    
        def helper(lst):
            rob1 = 0
            rob2 = 0

            for num in lst:
                temp = max(rob1 + num, rob2)
                rob1 = rob2
                rob2 = temp
            
            return rob2
        
        return max(nums[0], helper(nums[1:]), helper(nums[:-1]))
