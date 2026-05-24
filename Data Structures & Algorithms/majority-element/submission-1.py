class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        n = len(nums)/2
        res = 0
        freq = defaultdict(int)

        for num in nums:
            freq[num] += 1

            res = num if freq[num] > freq[res] else res

        return res