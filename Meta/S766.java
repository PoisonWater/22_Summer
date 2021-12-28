package Meta;

public class S766 {

    // 微观算法 更简洁，只比较每一个方块的左上临近的node！
    // 但不知道为什么 耗时一样 占更多空间
    public boolean isToeplitzMatrix1(int[][] matrix) {
        for (int r = 0; r < matrix.length; ++r)
            for (int c = 0; c < matrix[0].length; ++c)
                if (r > 0 && c > 0 && matrix[r-1][c-1] != matrix[r][c])
                    return false;
        return true;
    }

    // 宏观算法
    public boolean isToeplitzMatrix(int[][] matrix) {
        int mB = matrix.length, nB = matrix[0].length;
        int m = 0, n = 0;
        
        for (int i = 0; i < mB; i++) {
            n = 0;
            m = i;
            int pin = matrix[m][n];
            while (m < mB && n < nB) {
                if (matrix[m++][n++] != pin) {
                    return false;
                }
            }
        }
        
        for (int i = 0; i < nB; i++) {
            m = 0;
            n = i;
            int pin = matrix[m][n];
            while (m < mB && n < nB) {
                if (matrix[m++][n++] != pin) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
