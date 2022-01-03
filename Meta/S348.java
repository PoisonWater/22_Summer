package Meta;

class TicTacToe {
    
    int n;
    int[][] rows, cols;
    int[] diag, diag0;

    public TicTacToe(int n) {
        this.n = n;
        rows = new int[n][2];
        cols = new int[n][2];
        diag = new int[2];
        diag0 = new int[2];
    }
    
    public int move(int row, int col, int player) {
        // 1. add the move
        // 2. judging the move
        
        if (++rows[row][player - 1] == n) {
            return player;
        }
        if (++cols[col][player - 1] == n) {
            return player;
        }
        if (row == col && ++diag[player - 1] == n) {
            return player;
        }
        if (row + col == n - 1 && ++diag0[player - 1] == n) {
            return player;
        }
        
        return 0;
        
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
