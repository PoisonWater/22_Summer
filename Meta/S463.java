package Meta;

public class S463 {
    // BFS每一个Node 计算neighbor数量 有neighbor不加周长
    // 相当于traverse每一条边 累加
    public int islandPerimeter(int[][] grid) {
        int peri = 0;
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        for (int i = 0 ; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // for each node equals to 1:
                if (grid[i][j] == 1) {
                    for (int[] d : dirs) {
                        int m = i + d[0], n = j + d[1];
                        // inbound?
                        if (m < 0 || n < 0 || m >= grid.length || n >= grid[0].length) {
                            peri++;
                        } else {
                            // neighbouring node is empty, then 1 more link
                            if (grid[m][n] == 0) {
                                peri++;
                            }
                        }
                    }
                }

            }
        }
        
        return peri;
    }
}
