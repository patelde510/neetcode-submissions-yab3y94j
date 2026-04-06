class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        q = deque()
        fresh = 0
        minutes = 0

        for r in range(len(grid)):
            for c in range(len(grid[0])):
                if grid[r][c] == 1:
                    fresh += 1
                if grid[r][c] == 2:
                    q.append((r, c))
        
        directions = [
            [1, 0],
            [-1, 0],
            [0, 1],
            [0, -1]
        ]

        while fresh > 0 and q:
            length = len(q)

            for i in range(length):
                r, c = q.popleft()

                for dirR, dirC in directions:
                    row = r + dirR
                    col = c + dirC

                    if row >= 0 and row < len(grid) and col >= 0 and col < len(grid[0]) and grid[row][col] == 1:
                        q.append((row, col))
                        fresh -= 1
                        grid[row][col] = 2
            
            minutes += 1


        return minutes if fresh == 0 else -1
