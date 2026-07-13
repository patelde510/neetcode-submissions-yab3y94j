class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        fresh = 0
        minutes = 0
        q = deque()

        for r in range(len(grid)):
            for c in range(len(grid[0])):
                if grid[r][c] == 1:
                    fresh += 1
                elif grid[r][c] == 2:
                    q.append((r, c))
        
        directions = [
            [-1, 0],
            [0, 1],
            [1, 0],
            [0, -1]
        ]
        
        while q and fresh > 0:
            curLen = len(q)

            for i in range(curLen):
                r, c = q.popleft()
                
                for dR, dC in directions:
                    row = r + dR
                    col = c + dC
                
                    if row >= 0 and row < len(grid) and col >= 0 and col < len(grid[0]) and grid[row][col] == 1:
                        q.append((row, col))
                        grid[row][col] = 2
                        fresh -= 1
                    
            minutes += 1
        
        return minutes if fresh == 0 else -1