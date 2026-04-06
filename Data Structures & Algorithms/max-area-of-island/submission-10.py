class Solution:

    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        numRows = len(grid)
        numCols = len(grid[0])
    
        def dfs(row, col):
            if (row < 0 or row == numRows or col < 0 or col == numCols or grid[row][col] == 0):
                return 0

            grid[row][col] = 0

            return (1 + dfs(row+1, col) + dfs(row, col+1) + dfs(row-1, col) + dfs(row, col-1))
                    
        maxArea = 0
        for row in range(numRows):
            for col in range(numCols):
                maxArea = max(maxArea, dfs(row, col))
        
        return maxArea

        