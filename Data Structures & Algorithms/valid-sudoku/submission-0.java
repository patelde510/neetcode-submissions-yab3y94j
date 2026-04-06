class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (char[] row : board) {
            if (!isRowValid(row)) return false;
        }

        if (!isColValid(board)) return false;

        if (!isSquareValid(board)) return false;

        return true;
    }

    private boolean isRowValid(char[] row) {
        Set<Character> seen = new HashSet<>();
        for (char c : row) {
            if (c == '.') continue;
            if (!seen.add(c)) return false;
        }
        return true;
    }

    private boolean isColValid(char[][] board) {
        for (int col = 0; col < 9; col++) {
            Set<Character> seen = new HashSet<>();
            for (int row = 0; row < 9; row++) {
                char c = board[row][col];
                if (c == '.') continue;
                if (!seen.add(c)) return false;
            }
        }
        return true;
    }

    private boolean isSquareValid(char[][] board) {

        for (int i = 0; i < 9; i+=3) {
            for (int j = 0; j < 9; j+=3) {
                Set<Character> seen = new HashSet<>();

                for (int row = i; row < i+3; row++) {
                    for (int col = j; col < j+3; col++) {
                        char c = board[row][col];
                        if (c == '.') continue;
                        if (!seen.add(c)) return false;
                    }
                }

            }
        }
        return true;
    }
}
