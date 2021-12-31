package Meta;

import java.util.LinkedList;
import java.util.Queue;

public class S286 {
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
