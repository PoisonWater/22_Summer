package Meta;

public class S1011 {

    // Binary Search
    private boolean canShip(int[] weights, int days, int cap) {
        int curr = 0, ships = 0;
        for (int w : weights) {
            if (w > cap) { return false; } 
            if (curr + w <= cap) {
                curr += w;
            } else {
                ships++;
                curr = w;
            }
        }
        return days >= ships + 1; // 最后一艘船没加上！
    }
    
    public int shipWithinDays(int[] weights, int days) {
        int lo = 1, hi = 25_000_000, mid = 0; // ptr of binary search
        
        // Binary Search 求满足条件最大值模版
        while (lo <= hi) { // 小于等于！<=
            mid = (lo + hi) / 2;
            
            if (canShip(weights, days, mid)) {
                hi = mid - 1; // hi 更新为 mid - 1
            } else {
                lo = mid + 1; // lo 更新为 mid + 1
            }
            
        }
        
        return lo; // return lo
    }

}
