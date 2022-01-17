package Meta;

class NumMatrix {
    
    int[][] preSum;

    public NumMatrix(int[][] matrix) {
        
        // add 1 for padding with 0
        preSum = new int[matrix.length + 1][matrix[0].length + 1];
        
        // fill preSum
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                preSum[i+1][j+1] = preSum[i][j+1] + preSum[i+1][j] + matrix[i][j] - preSum[i][j];
            }
        }
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2+1][col2+1] + preSum[row1][col1] - preSum[row2+1][col1] - preSum[row1][col2+1];
    }
}