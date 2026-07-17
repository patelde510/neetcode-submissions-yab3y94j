"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

class Solution:
    def minMeetingRooms(self, intervals: List[Interval]) -> int:
        start = sorted([s.start for s in intervals])
        end = sorted([e.end for e in intervals])

        cur = 0
        res = 0
        s, e = 0, 0

        while s < len(start) and e < len(end):
            if start[s] < end[e]:
                cur += 1
                res = max(res, cur)
                s += 1
            else:
                cur -= 1
                e += 1
        
        return res


