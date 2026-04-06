class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        count = {}
        freq = [[] for i in range(n + 1)]
        output = []

        for num in nums:
            count[num] = count.get(num, 0) + 1

        for key, value in count.items():
            freq[value].append(key)
        
        index = 0
        for i in range(n, 0, -1):
            for num in freq[i]:
                output.append(num)
                index += 1
                if (index == k):
                    return output

        return output
        