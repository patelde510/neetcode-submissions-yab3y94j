class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        res = max(nums)
        curMin, curMax = 1, 1

        for n in nums:
            if n == 0:
                curMin, curMax = 1, 1
                continue
            
            tempMin = min(n, curMin * n, curMax * n)
            tempMax = max(n, curMin * n, curMax * n)
            curMin = tempMin
            curMax = tempMax

            res = max(res, curMax)

        return res
