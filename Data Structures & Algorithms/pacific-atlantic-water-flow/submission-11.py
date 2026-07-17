class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        ROWS = len(heights)
        COLS = len(heights[0])

        pacific = [[False for _ in range(COLS)] for _ in range(ROWS)]
        atlantic = [[False for _ in range(COLS)] for _ in range(ROWS)]

        directions = [
            [1, 0],
            [-1, 0],
            [0, 1],
            [0, -1]
        ]
        
        def dfs(r, c, ocean):
            if ocean[r][c]:
                return
            
            ocean[r][c] = True

            for d in directions:
                newR = r + d[0]
                newC = c + d[1]

                if newR >= 0 and newR < ROWS and newC >= 0 and newC < COLS and not ocean[newR][newC]:
                    if heights[newR][newC] >= heights[r][c]:
                        dfs(newR, newC, ocean)
            
        for r in range(ROWS):
            dfs(r, 0, pacific)
            dfs(r, COLS-1, atlantic)
        
        for c in range(COLS):
            dfs(0, c, pacific)
            dfs(ROWS-1, c, atlantic)

        res = []
        
        for r in range(ROWS):
            for c in range(COLS):
                if pacific[r][c] and atlantic[r][c]:
                    res.append([r, c])
        
        return res
