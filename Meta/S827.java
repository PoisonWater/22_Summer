package Meta;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class S827 {

    // R2
    // https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/
    // 1. Find Areas for each island
    // 2. Try adding each node
    public int largestIsland(int[][] grid) {
        
        // Get area
        HashMap<Integer, Integer> map = new HashMap<>();
        int graphIndex = 2, max = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int area = getArea(grid, i, j, graphIndex);
                    map.put(graphIndex++, area);
                    max = area > max ? area : max; // 要记录最大单岛面积 防止只有一个岛的情况！！！
                }
            }
        }
        
        // Trial of adding each node
        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    int area = 1;
                    Set<Integer> tmpSet = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        if (i + dr[k] >= 0 && j + dc[k] >= 0 && i + dr[k] < grid.length 
                            && j + dc[k] < grid[0].length && !tmpSet.contains(grid[i + dr[k]][j + dc[k]])
                            && grid[i + dr[k]][j + dc[k]] > 1) {
                            tmpSet.add(grid[i + dr[k]][j + dc[k]]);
                            area += map.get(grid[i + dr[k]][j + dc[k]]);
                        }
                    }
                    max = area > max ? area : max;
                }
            }
        }
        
        return max;
        
    }
    
    private int getArea(int[][] grid, int row, int col, int ind) {
        
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != 1) {
            return 0;
        }
        
        // update grid with ind
        grid[row][col] = ind;
        
        // dfs to get area
        return 1 + getArea(grid, row+1, col, ind) + getArea(grid, row-1, col, ind) 
            + getArea(grid, row, col+1, ind) + getArea(grid, row, col-1, ind);
    }
}
