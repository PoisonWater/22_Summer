package Meta;

public class S695 {
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    private int area(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != 1) {
            return 0;
        }
        grid[row][col] = 2;
        int lclArea = 1;
        for (int[] d : dirs) {
            lclArea += area(grid, row + d[0], col + d[1]);
        }
        return lclArea;
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, area(grid, i, j));
                }
            }
        }
        
        return maxArea;
    }
}
