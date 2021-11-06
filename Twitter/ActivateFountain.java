// SKIPPED
// https://leetcode.com/discuss/interview-question/363036/walmart-oa-2019-activate-fountains
// https://leetcode-cn.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/solution/guan-gai-hua-yuan-zui-shao-de-shui-long-ieb7y/

import java.util.Arrays;

class ActivateFountain {
    
    public int minTaps1(int n, int[] ranges) {
        //1. 贪心解, 将水龙头转化为对应能覆盖的区间
        //1.1 maxP数组为每个 i 位置能覆盖到的最右位置, n+1 是因为要等于水龙头的个数
        int maxP[] = new int[n+1];
        int maxPosition = 0, end = 0, steps = 0;

        //2. 转化过程, 遍历 n+1 个水龙头
        for(int i = 0; i <= n;i++){
            //2.1 left = 每个水龙头最左能覆盖的位置, 以0为下界
            int left = Math.max(i-ranges[i], 0);
            //2.2 right = 最右能覆盖的位置, 以n为上界
            int right = Math.min(i+ranges[i], n);
            //2.3 将区间转化为 left 出发的最大可达位置(right) , 省去建立二维数组的步骤
            maxP[left] = Math.max(maxP[left], right);
        }

        //3. 遍历区间数组
        for(int i = 0; i<n;i++){
            //3.1 累计记录最大可达位置
            maxPosition = Math.max(maxPosition, maxP[i]);
            //3.2 更新最大可达位置后, 依然等于当前位置, 代表下一位置不可达, 区间断裂
            if (i == maxPosition){
                return -1;
            }
            //3.3 end 为可达位置的最右边界, 当前指针到达边界, 即代表上一区间已使用完, 步数加一
            if (i == end){
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public int minTaps(int n, int[] ranges) {
        int[][] cover = new int[n+1][2];
        for(int i=0;i<n+1;i++){
            cover[i][0] = Math.max(0,i-ranges[i]);
            cover[i][1] = Math.min(i+ranges[i],n);
        }
        Arrays.sort(cover,(a,b) -> a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        int ans = 0;
        int end = 0,i = 0,l = 0;
        while(end < n){
            while(i < n+1 && cover[i][0] <= end){
                l = Math.max(l,cover[i][1]);
                i++;
            }
            if(l==end) return -1; // NO COVERAGE
            end = l;
            ans++;
        }
        return ans;
    }

}
