package Meta;

import java.util.LinkedList;
import java.util.Queue;

public class S286 {

    // R2
    // find gates - 0
    // queue - BFS
    
    public void wallsAndGatesR2(int[][] rooms) {
        
        
        // Queue Init
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
                
            }
        }
        
        // BFS
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                
                int[] curr = queue.poll();
                
                for (int[] d : dirs) {
                    
                    int[] next = new int[]{curr[0] + d[0], curr[1] + d[1]};
                    
                    // Inbound && Unvisited
                    if (next[0] >= 0 && next[0] < rooms.length && 
                        next[1] >= 0 && next[1] < rooms[0].length && rooms[next[0]][next[1]] == Integer.MAX_VALUE) {
                        queue.offer(next);
                        rooms[next[0]][next[1]] = step;
                    }
                    
                }
                
            }
        }
        
    }

    // Revisit - TODO：Graph BFS
    public void wallsAndGatesR(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
        // List<int[]> gates = new ArrayList<>();
        
        // Find gates:
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++){
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        
        // BFS
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++; // 注意 每一步都更新填充进queue的step 不然会出现错位

            // Generate next step;
            for (int i = 0; i < size; i++) {
                
                // update step
                int[] curr = queue.poll();
                
                // offer next index
                for (int[] dir : dirs) {
                    
                    int[] next = new int[]{curr[0] + dir[0], curr[1] + dir[1]};
                    
                    // In bound && INF?
                    if (next[0] >=0 && next[1] >= 0 && next[0] < rooms.length && next[1] < rooms[0].length
                        && step < rooms[next[0]][next[1]]) { // 注意这里不用Max比较 只要有更小的就放进来
                        rooms[next[0]][next[1]] = step;
                        queue.offer(next);
                    }
                    
                }
            }
        }
    }

    
    public void wallsAndGates(int[][] rooms) {
        
        // BFS
        Queue<Integer> mq = new LinkedList<>(); // keep track of m index
        Queue<Integer> nq = new LinkedList<>(); // keep track of m index
        int mB = rooms.length, nB = rooms[0].length;
        
        // find gates and put into queue;
        for (int i = 0; i < mB; i++) {
            for (int j = 0; j < nB; j++) {
                if (rooms[i][j] == 0) {
                    mq.offer(i);
                    nq.offer(j);
                }
            }
        }
        // By now, all gates were added into the queue
        
        // Now BFS the empty spaces starting from each gate;
        int steps = 0;
        int[][] dirs = new int[][]{{1,0}, {0,1}, {-1, 0}, {0,-1}};
        while (!mq.isEmpty()) {
            // loop through current iteration of spaces, offer in queue
            int size = mq.size();
            steps++;
            
            for (int i = 0; i < size; i++) {
                int m = mq.poll();
                int n = nq.poll();
                for (int[] dir : dirs) {
                    // 1. in range 0-nB/mB; 2. steps < rooms[m][n];
                    // then offer it into queue and change value rooms[m][n]
                    if (m + dir[0] >= 0 && m + dir[0] < mB && n + dir[1] >= 0 && n + dir[1] < nB 
                        && steps < rooms[m + dir[0]][n + dir[1]]) {
                        rooms[m + dir[0]][n + dir[1]] = steps;
                        mq.offer(m + dir[0]);
                        nq.offer(n + dir[1]);
                    }
                }
            }
        }
    }
}
