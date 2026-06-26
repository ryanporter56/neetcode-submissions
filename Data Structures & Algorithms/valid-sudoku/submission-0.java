class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rowSet = new HashSet[board.length];
        Set<Character>[] columnSet = new HashSet[board.length];
        Set<Character>[] boxSet = new HashSet[board.length];

        for (int k = 0; k < board.length; k++) {
            rowSet[k] = new HashSet<>();
            columnSet[k] = new HashSet<>();
            boxSet[k] = new HashSet<>();
        }

        // i is the index for rows, j is the index for columns
        // construct sets
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (!rowSet[i].add(board[i][j])) {
                    return false;
                }

                if (!columnSet[j].add(board[i][j])) {
                    return false;
                }

                int boxIndex = (i/3) * 3 + (j/3);
                if (!boxSet[boxIndex].add(board[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }
}
