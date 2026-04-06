class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        count = defaultdict(int)
        freq = [[] for i in range(n+1)]
        res = []

        for num in nums:
            count[num] += 1

        for key, value in count.items():
            freq[value].append(key)
        
        for i in range(n, 0, -1):
            for num in freq[i]:
                if k == 0:
                    break
                res.append(num)
                k -= 1
                
        return res
        