package Meta;

public class S498 {
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
