package Meta;

import java.util.LinkedList;
import java.util.Queue;

public class S934 {
    // EXPAND ISLAND!
    // TODO 做错了
    // 一定要重新开一个int[][]来记录分组，直接在原数组上操作也可以，别作死
    public int shortestBridge(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        // init bfs
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    // add into queue
                    queue.offer(new int[]{i, j});
                    // update visited 2d array
                    visited[i][j] = true;
                }
            }
        }
        
        // BFS
        int bLen = 1; // bridge length
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            // all points to be added is traversed
            for (int i = 0; i < size; i++) {
                
                int[] curr = queue.poll();
                if (grid[curr[0]][curr[1]] == 1) {return bLen;}
                
                // all directions
                for (int[] dir : dirs) {
                    if (!visited[curr[0]+dir[0]][curr[1]+dir[1]]) {
                        visited[curr[0]+dir[0]][curr[1]+dir[1]] = true;
                        queue.offer(new int[]{curr[0]+dir[0], curr[1]+dir[1]});
                    }
                }
                
                
            }
            bLen++;
        }
        return 0;
    }
}
