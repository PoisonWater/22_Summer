package Meta;

import java.util.Arrays;

public class S986 {

    // Revisit
    public int[][] intervalIntersectionR(int[][] firstList, int[][] secondList) {
        int p1 = 0, p2 = 0, b1 = firstList.length - 1, b2 = secondList.length - 1, size = 0;
        int[][] ret = new int[b1 + b2 + 2][2];
        
        while (p1 <= b1 && p2 <= b2) {
            // 1. Current intervals overlap? Contains start = end overlap
            int s1 = firstList[p1][0], s2 = secondList[p2][0], e1 = firstList[p1][1], e2 = secondList[p2][1];
            int start = Math.max(s1, s2), end = Math.min(e1, e2);
            if (start > end) {
                if (e1 < e2) {
                    p1++;
                } else {
                    p2++;
                }
                continue;
            }
            
            // 2. get merge interval and append
            ret[size] = new int[]{start, end};
            size++;
            
            // 3. update p1 OR p2
            if (e1 < e2) {
                p1++;
            } else {
                p2++;
            }
        }
        
        return Arrays.copyOfRange(ret, 0, size);
    }


    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        int p1 = 0, p2 = 0;
        int[][] ret = new int[firstList.length + secondList.length][2];
        int k = 0; // 可以超额建立int array 最后copyOfRange，避免重录浪费空间时间
        
        while (p1 < firstList.length && p2 < secondList.length) {
            
            int interLo = Math.max(firstList[p1][0], secondList[p2][0]); // 最晚开始
            int interHi = Math.min(firstList[p1][1], secondList[p2][1]); // 最早结束
            
            // 最晚开始 < 最早结束时间 则有overlap
            
            if (interLo <= interHi) {
                ret[k][0] = interLo;
                ret[k][1] = interHi;
                k++;
            }
            
            if (firstList[p1][1] < secondList[p2][1]) {
                p1++;
            } else if (firstList[p1][1] == secondList[p2][1]) {
                p1++;
                p2++;
            } else {
                p2++;
            }
            
        }

        return Arrays.copyOfRange(ret, 0, k);
        
    }
}
