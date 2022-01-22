package Meta;

import java.util.LinkedList;
import java.util.Queue;

// R2
class S1091R2 {
    
    // BFS
    // Step-by-step 
    // 0 0 0
    // 1 1 0
    // 1 1 0
    
    // 1 1
    // 1 1
    
    // 0

    // 如果要求return path list
    // 在每个节点存一个父节点
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        // corner case
        // Two corners are 0
        if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) {
            return -1;
        }
        
        // visited[][] Init
        int mLen = grid.length, nLen = grid[0].length;
        if (mLen == 1 && nLen == 1) { return 1; }
        
        boolean[][] visited = new boolean[mLen][nLen];
        for (int i = 0; i < mLen; i++) {
            for (int j = 0; j < nLen; j++) {
                // default false
                // grid[i][j] == 1, visited
                if (grid[i][j] == 1) {
                    visited[i][j] = true;
                }
            }
        }
        
        // BFS indices
        int path = 1;
        int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}, {1,1}, {1,-1}, {-1,1}, {-1,-1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            path++;
            
            for (int i = 0; i < size; i++) { // each node inside
                int[] curr = queue.poll();
                
                for (int[] d : dirs) { // eight directions
                    int[] next = new int[]{ curr[0] + d[0], curr[1] + d[1] };
                    
                    // final node?
                    if (next[0] == mLen - 1 && next[1] == nLen - 1) { return path; }
                    
                    // out bound / visited?
                    if (next[0] < 0 || next[0] >= mLen || next[1] < 0 || next[1] >= nLen || visited[next[0]][next[1]]) {
                        continue;
                    }
                    
                    // visited and offer
                    visited[next[0]][next[1]] = true;
                    queue.offer(next);
                    
                }
                
            }
        }
        
        return -1;
        
    }
}



public class S1091 {

    // Revisited
    // Graph BFS - Better with A*
    public int shortestPathBinaryMatrix1(int[][] grid) {
    
        // CORNER Cases!!!
        if (grid[0][0] == 1) { return -1; }
        
        // graph BFS Init:
        Queue<int[]> queue = new LinkedList<>(); // Storing step-wise path information in queue
        queue.offer(new int[]{0, 0});
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int step = 0, mB = grid.length - 1, nB = grid[0].length - 1;
        
        // 注意二维数组快速初始方式！！
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        
        // Start BFS:
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                
                // Reaching target node
                if (curr[0] == mB && curr[1] == nB) {return step;}
                
                // update queue with eligible nodes
                for (int[] dir : dirs) {
                    // 这里定义curr[1]+dir[1]变量会好很多
                    if (curr[0]+dir[0] < 0 || curr[1]+dir[1] < 0 || curr[0]+dir[0] > mB || curr[1]+dir[1] > nB
                        || grid[curr[0]+dir[0]][curr[1]+dir[1]] == 1 || visited[curr[0]+dir[0]][curr[1]+dir[1]]) {
                        continue;
                    }
                    queue.offer(new int[]{curr[0]+dir[0], curr[1]+dir[1]});
                    visited[curr[0]+dir[0]][curr[1]+dir[1]] = true; // 记得 update visited！！！
                }
                
            }
        }
        
        return -1;
        
    }

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
