class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        count = defaultdict(int)
        freq = [[] for i in range(n+1)]
        res = []

        for num in nums:
            count[num] += 1
        
        for n, c in count.items():
            freq[c].append(n)

        for i in range(len(nums), -1, -1):
            if k <= 0:
                break
            if freq[i]:
                for j in freq[i]:
                    res.append(j)
                    k -= 1

        return res