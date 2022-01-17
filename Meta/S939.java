package Meta;

import java.util.HashMap;
import java.util.HashSet;

public class S939 {
    private int getArea(int[] p1, int[] p2) {
        return Math.abs((p1[0] - p2[0]) * (p1[1] - p2[1]));
    }
    
    public int minAreaRect(int[][] points) {
        
        // Build Map
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int[] pt : points) {
            map.putIfAbsent(pt[0], new HashSet<>());
            map.get(pt[0]).add(pt[1]);
        }
        
        // On2 traversal
        int minArea = Integer.MAX_VALUE;
        
        for (int i = 0; i < points.length - 1; i++) {
            int[] pt1 = points[i];
            for (int j = i + 1; j < points.length; j++) {
                int[] pt2 = points[j];
                
                // cannot rect
                if (pt1[0] == pt2[0] || pt1[1] == pt2[1]) {
                    continue;
                }
                
                if (map.get(pt1[0]).contains(pt2[1]) && map.get(pt2[0]).contains(pt1[1])) {
                    int area = getArea(pt1, pt2);
                    minArea = area < minArea ? area : minArea;
                }
            }
        }
        
        if (minArea == Integer.MAX_VALUE) { return 0; }
        
        return minArea;
        
    }
}
