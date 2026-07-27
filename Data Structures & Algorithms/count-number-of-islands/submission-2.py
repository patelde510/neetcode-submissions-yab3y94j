class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        ROWS = len(grid)
        COLS = len(grid[0])
        res = 0

        directions = [
            [1, 0],
            [0, 1],
            [-1, 0],
            [0, -1]
        ]

        def dfs(r, c):
            if grid[r][c] == "0":
                return

            grid[r][c] = "0"
            
            for d in directions:
                newR = r + d[0]
                newC = c + d[1]

                if newR >= 0 and newR < ROWS and newC >= 0 and newC < COLS:

                    dfs(newR, newC)

        res = 0

        for r in range(ROWS):
            for c in range(COLS):
                if grid[r][c] == "1":
                    dfs(r, c)
                    res += 1

        return res