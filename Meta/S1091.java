package Meta;

import java.util.LinkedList;
import java.util.Queue;

public class S1091 {

    // Graph BFS on matrix
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int len1 = grid.length, len2 = grid[0].length;
        
        if (grid[0][0] == 1) {return -1;}
        
        int[][] dir = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}, {1,1}, {1,-1}, {-1,1}, {-1,-1}}; // 二维数组初始化赋值
        
        boolean[][] visited = new boolean[len1][len2]; // 二维数组空初始化
        visited[0][0] = true;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        
        int len = 0;
        
        while (!queue.isEmpty()) { // 每个while loop走一步 方便计算路程长度 
            
            int qs = queue.size();
            len++;

            for (int i = 0; i < qs; i++) { // for loop 穷举可以迈出的下一步
                
                int[] curr = queue.poll();
                // 注意！在这里visited非常慢！
                // node进Queue就要visited！防止在下一个for loop重复多次添加！！
                // visited[curr[0]][curr[1]] = true;
                
                if (curr[0] == len1 - 1 && curr[1] == len2 - 1) {
                    return len;
                }

                for (int[] d : dir) {
                    int d0 = curr[0] + d[0], d1 = curr[1] + d[1]; // next index
                    if (d0 >= 0 && d0 < len1 && d1 >= 0 && d1 < len2 && !visited[d0][d1] && grid[d0][d1] == 0) {
                        queue.offer(new int[]{d0, d1});
                        visited[d0][d1] = true; // node进Queue就要visited！防止在下一个loop重复多次添加！！
                    }
                }
            }

        }
        
        return -1;
        
    }
}
