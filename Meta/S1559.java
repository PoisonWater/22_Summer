package Meta;

import java.util.HashSet;

public class S1559 {
    // TODO 重写
    private int[][] dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
    private boolean[][] visitedPt;
    
    // input grid and prev ij
    private boolean dfs(char[][] grid, int currI, int currJ, int prevI, int prevJ, char target){
        
        // 注意！先判断当前位是否为target！
        if (grid[currI][currJ] != target) {return false;}
        visitedPt[currI][currJ] = true;
        
        // 判断各个方向
        for (int[] dir : dirs) {
            int[] next = new int[]{currI+dir[0], currJ+dir[1]};
            
            // outbound or conflict?
            if (next[0] < 0 || next[0] >= grid.length || next[1] < 0 || next[1] >= grid[0].length ||
                (next[0] == prevI && next[1] == prevJ)) {
                continue;
            }
                
            // match?
            if (grid[next[0]][next[1]] == target && visitedPt[next[0]][next[1]]) {
                return true;
            }
                
            // continueDFS
            if (dfs(grid, next[0], next[1], currI, currJ, target)) {
                return true;
            }
            
        }
        return false;
        
    }
    
    public boolean containsCycle(char[][] grid) {
        // contains visited chars
        HashSet<Character> visited = new HashSet<>();
        // 注意 要有2nd visited points
        visitedPt = new boolean[grid.length][grid[0].length];
        
        // loop through grid elements
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                
                // if not visited, dfs char to find cycle;
                if (!visited.contains(grid[i][j])) {
                    visited.add(grid[i][j]);
                    if (dfs(grid, i, j, -3, -3, grid[i][j])) {
                        return true;
                    }
                }

            }
        }
        
        // no cycles found
        return false;
        
    }
}
