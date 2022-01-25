package Meta;

// R2
// Revisit
class TicTacToeR {

    int[][] rows, cols;
    int[] diag, antiDiag;
    int size;

    public TicTacToeR(int n) {
        // sum of moves for each of the players
        rows = new int[n][2]; 
        cols = new int[n][2];
        diag = new int[2];
        antiDiag = new int[2];
        size = n;
    }
    
    // 注意player转index要减1！
    public int move(int row, int col, int player) {
        // 1. Row
        if (++rows[row][player-1] == size) {
            return player;
        }
        // 2. Col
        if (++cols[col][player-1] == size) {
            return player;
        }
        // 3. Diag
        if (row == col && ++diag[player-1] == size) {
            return player;
        }
        // 4. AntiDaig
        if (row + col + 1 == size && ++antiDiag[player-1] == size) {
            return player;
        }
        return 0;
    }
    
}



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
