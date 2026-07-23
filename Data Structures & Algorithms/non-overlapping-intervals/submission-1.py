class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        intervals.sort(key = lambda pair : pair[0])

        prevE = intervals[0][1]
        res = 0

        for start, end in intervals[1:]:
            if start < prevE:
                res += 1
                prevE = min(prevE, end)
            else:
                prevE = end
        
        return res
        