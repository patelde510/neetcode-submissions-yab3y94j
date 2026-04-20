class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        directions = [
            [1, 0],
            [-1, 0],
            [0, 1],
            [0, -1]
        ]
        rows = len(heights)
        cols = len(heights[0])

        pacific = [[False for _ in range(cols)] for _ in range(rows)]
        atlantic = [[False for _ in range(cols)] for _ in range(rows)]

        def dfs(r, c, ocean):
            if ocean[r][c]:
                return

            ocean[r][c] = True
            for d in directions:
                newR = r + d[0]
                newC = c + d[1]
                
                if newR >= 0 and newR < rows and newC >= 0 and newC < cols and not ocean[newR][newC]:
                    if heights[newR][newC] >= heights[r][c]:
                        dfs(newR, newC, ocean)

        for r in range(rows):
            dfs(r, 0, pacific)
            dfs(r, cols-1, atlantic)

        for c in range(cols):
            dfs(0, c, pacific)
            dfs(rows-1, c, atlantic)

        res = []

        for r in range(rows):
            for c in range(cols):
                if pacific[r][c] and atlantic[r][c]:
                    res.append([r, c])
        return res
        