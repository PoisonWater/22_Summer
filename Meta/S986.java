package Meta;

import java.util.Arrays;

public class S986 {
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
