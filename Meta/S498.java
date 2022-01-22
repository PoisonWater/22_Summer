package Meta;

public class S498 {

    // R2
    public int[] findDiagonalOrder(int[][] mat) {
        
        // ptr and length
        int i = 0, j = 0, ptr = 0;
        // 注意bound是length - 1！
        int m = mat.length, n = mat[0].length;
        int[] ret = new int[m*n];
        boolean up = true;
        
        // traverse 
        while (ptr < ret.length) {
            
            // assign
            ret[ptr++] = mat[i][j];
            
            // conditions for next assginment
            if (up) {
                //bound
                if (j == n - 1) {
                    up = !up; // reverse
                    i++; // down
                } else if (i == 0) {
                    up = !up; // reverse;
                    j++; // right
                } else {
                    i--; // up
                    j++; // r
                }
            } else {
                //bound
                if (i == m - 1) {
                    up = !up; // reverse
                    j++; // right
                } else if (j == 0) {
                    up = !up; // reverse;
                    i++; // down
                } else {
                    i++; // up
                    j--; // r
                }
            }
            
        }
        
        return ret;
        
    }
    // Revisit
    public int[] findDiagonalOrder(int[][] mat) {
        
        // Boundaries index int[m][n]
        // m - 0, mat.length;
        // n - 0, mat[0].length;
        // pivot - traverse direction;
        
        int m = 0, n = 0, mB = mat.length, nB = mat[0].length;
        boolean pivot = false;
        int[] ret = new int[mB*nB];
        int ptr = 0;
        
        while (ptr < mB*nB) {
            // add current to ret array
            ret[ptr++] = mat[m][n];
            
            // identify next index
            if (pivot) { // 左下
                if (n - 1 < 0 && m + 1 == mB) { // corner
                    n = 1;
                } else if (n - 1 < 0) {
                    m++;
                } else if (m + 1 == mB) {
                    n++;
                } else {
                    m++;
                    n--;
                    continue;
                }
                pivot = !pivot;
                
            } else { // 右上
                if (m - 1 < 0 && n + 1 == nB) { // corner
                    m = 1;
                } else if (m - 1 < 0) {
                    n++;
                } else if (n + 1 == nB) {
                    m++;
                } else {
                    m--;
                    n++;
                    continue;
                }
                pivot = !pivot;
                
            }
        }
        return ret;
        
    }
}
