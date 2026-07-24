class Solution:
    def solve(self, board: List[List[str]]) -> None:
        ROWS = len(board)
        COLS = len(board[0])

        directions = [
            [0, 1],
            [1, 0],
            [-1, 0],
            [0, -1]
        ]

        def dfs(r, c):
            if board[r][c] == 'X' or board[r][c] == 'd':
                return
            
            board[r][c] = 'd'
            for d in directions:
                newR = r + d[0]
                newC = c + d[1]
                if newR >= 0 and newR < ROWS and newC >= 0 and newC < COLS:
                    dfs(newR, newC)
        
        for r in range(ROWS):
            dfs(r, 0)
            dfs(r, COLS-1)

        for c in range(COLS):
            dfs(0, c)
            dfs(ROWS-1, c)
        
        for r in range(ROWS):
            for c in range(COLS):
                if board[r][c] == 'O':
                    board[r][c] = 'X'
                elif board[r][c] == 'd':
                    board[r][c] = 'O'
