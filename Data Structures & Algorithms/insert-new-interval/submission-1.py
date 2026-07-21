class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        intervals.append(newInterval)
        intervals.sort(key = lambda pair : pair[0])

        res = [intervals[0]]

        for start, end in intervals[1:]:
            prevE = res[-1][1]
            if start <= prevE:
                res[-1][1] = max(prevE, end)
            else:
                res.append([start, end])
        
        return res