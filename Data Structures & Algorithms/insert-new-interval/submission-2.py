class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        if not intervals:
            return [newInterval]

        n = len(intervals)
        target = newInterval[0]
        l, r = 0, n-1

        while l <= r:
            mid = (l + r) // 2
            if intervals[mid][0] < target:
                l = mid + 1
            else:
                r = mid - 1
        
        intervals.insert(l, newInterval)

        res = []

        for i in intervals:
            if res and res[-1][1] >= i[0]:
                res[-1][1] = max(res[-1][1], i[1])
            else:
                res.append(i)
        
        return res

