class MedianFinder:

    def __init__(self):
        # Max Heap  Min Heap
        self.small, self.large = [], []

    def addNum(self, num: int) -> None:
        heapq.heappush(self.small, -1 * num)
        
        # Make sure the largest value in small is less than the smallest value in large
        if self.small and self.large and (-1 * self.small[0] > self.large[0]):
            val = -1 * heapq.heappop(self.small)
            heapq.heappush(self.large, val)
        
        # Check if size is within 1
        if len(self.small) > len(self.large)+1:
            val = -1 * heapq.heappop(self.small)
            heapq.heappush(self.large, val)

        if len(self.large) > len(self.small)+1:
            val = heapq.heappop(self.large)
            heapq.heappush(self.small, -1 * val)

    def findMedian(self) -> float:
        
        if len(self.small) > len(self.large):
            return -1 * self.small[0]
        
        if len(self.large) > len(self.small):
            return self.large[0]

        return ((-1 * self.small[0]) + self.large[0]) / 2