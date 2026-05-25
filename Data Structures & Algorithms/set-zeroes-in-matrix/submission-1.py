class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        m, n = len(matrix), len(matrix[0])
        update = set()

        def dfs(r, c):
            for i in range(n):
                matrix[r][i] = 0
            
            for i in range(m):
                matrix[i][c] = 0

        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 0:
                    update.add((i, j))

        for r, c in update:
            dfs(r, c)
        