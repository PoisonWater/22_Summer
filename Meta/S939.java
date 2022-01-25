package Meta;

import java.util.HashMap;
import java.util.HashSet;

public class S939 {

    // R2
    private int areaOf(int[] p1, int[] p2) {
        return Math.abs((p1[0] - p2[0]) * (p1[1] - p2[1]));
    }
    
    public int minAreaRectR2(int[][] points) {
        // HashMap
        // row - set<col>
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            map.putIfAbsent(points[i][0], new HashSet<>());
            map.get(points[i][0]).add(points[i][1]);
        }
        
        // Traverse nodes to find diagnal pts - match map
        
        int minArea = Integer.MAX_VALUE;
        
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                // same row or column we need to continue
                if (points[i][0] == points[j][0] || points[i][1] == points[j][1]) {
                    continue;
                }
                
                // has diagnal points then update minArea
                if (map.get(points[i][0]).contains(points[j][1]) && map.get(points[j][0]).contains(points[i][1])) {
                    minArea = Math.min(minArea, areaOf(points[i], points[j]));
                }
            }
        }
        
        // Corner Case
        if (minArea == Integer.MAX_VALUE) { return 0; }
        
        return minArea;
        
    }

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
