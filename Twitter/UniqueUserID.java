package Twitter;
// https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique/solution/ji-shu-onxian-xing-tan-ce-fa-onpai-xu-onlogn-yi-ya/
// https://leetcode.com/discuss/interview-question/376581/Twitter-or-OA-2019-or-Unique-Twitter-User-Id-Set

import java.util.Arrays;

public class UniqueUserID {

    // 1. 排序
    public int minIncrementForUnique(int[] A) {
        // 先排序
        Arrays.sort(A);
        int move = 0;
        // 遍历数组，若当前元素小于等于它的前一个元素，则将其变为前一个数+1
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= A[i - 1]) {
                int pre = A[i];
                A[i] = A[i - 1] + 1;
                move += A[i] - pre;
            }
        }
        return move;
    }

    // 2. Mapping
    // Mapping to integer map
    public int getUniqueUserIdSum(int[] arr) {
        // counter数组统计每个数字的个数。
        //（这里为了防止下面遍历counter的时候每次都走到40000，所以设置了一个max，这个数据量不设也行，再额外设置min也行）
        int[] counter = new int[2001];
        int max = -1;
        for (int num: arr) {
            counter[num]++;
            max = Math.max(max, num);
        }
        
        // 遍历counter数组，若当前数字的个数cnt大于1个，则只留下1个，其他的cnt-1个后移
        int move = 0;
        for (int num = 0; num <= max; num++) {
            if (counter[num] > 1) {
                int d = counter[num] - 1;
                move += d;
                counter[num + 1] += d;
            }
        }
        // 最后, counter[max+1]里可能会有从counter[max]后移过来的，counter[max+1]里只留下1个，其它的d个后移。
        // 设 max+1 = x，那么后面的d个数就是[x+1,x+2,x+3,...,x+d],
        // 因此操作次数是[1,2,3,...,d],用求和公式求和。
        int d = counter[max + 1] - 1;
        move += (1 + d) * d / 2;
        return move;
	}
}
