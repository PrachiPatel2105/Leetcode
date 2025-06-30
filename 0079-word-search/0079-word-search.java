class Solution {
    private int rows;
    private int cols;
    private String targetWord;
    private char[][] gameBoard;
    public boolean exist(char[][] board, String word) {
        rows = board.length;      
        cols = board[0].length;   
        targetWord = word;        
        gameBoard = board;        
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(int row, int col, int index) {
        if (index == targetWord.length() - 1) {
            return gameBoard[row][col] == targetWord.charAt(index);
        }
        if (gameBoard[row][col] != targetWord.charAt(index)) {
            return false;
        }
        char tempChar = gameBoard[row][col];
        gameBoard[row][col] = '0';
        int[] directions = {-1, 0, 1, 0, -1};
        for (int d = 0; d < 4; ++d) {
            int newRow = row + directions[d];
            int newCol = col + directions[d + 1];
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && gameBoard[newRow][newCol] != '0') {
                if (dfs(newRow, newCol, index + 1)) {
                    return true;
                }
            }
        }
        gameBoard[row][col] = tempChar;
        return false;
    }
}