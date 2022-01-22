package Meta;

public class S1011 {

    // R2
    private boolean canShip2(int[] weights, int days, int cap) {
        // can ship?
        int currDay = 1, load = 0, ptr = 0;
        while (ptr < weights.length) {
            // larger than ship
            if (weights[ptr] > cap) {
                return false;
            }
            // load
            load += weights[ptr];
            if (load > cap) {
                load = weights[ptr]; // 注意load什么，不应该减cap
                currDay++;
            }
            ptr++;
        }
        return currDay <= days;
    }
    
    public int shipWithinDaysR2(int[] weights, int days) {
        
        // Binary Search
        int lo = 1, hi = 25_000_000;
        
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            
            boolean isShippable = canShip2(weights, days, mid);
            
            // conditions
            if (isShippable) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
            
        }
        
        return lo;
        
    }

    // Revisit - 注意binary search限制bound！！！
    public int shipWithinDaysR(int[] weights, int days) {
        
        // Get lo hi bound for bin search
        // 注意：binary search的bound必须严格！不然容易超bound！不要怕麻烦！
        int lo = 1, hi = 25000000;
        
        for (int w : weights) { // lo 必须大于等于货物最大值！
            lo = Math.max(lo, w);
        }
        
        // bin search
        while (lo <= hi) {
            // get travel days - actual
            int estDay = 0, cap = 0, mid = (lo + hi) / 2;
            for (int w : weights) {
                if (cap + w > mid) { // 没有限制lo 可能在这里超出范围并将w归零！
                    estDay++;
                    cap = 0;
                }
                cap += w; // 别忘更新船上装的货物重量
            }
            estDay++;
            
            // update lo hi
            if (estDay > days) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        
        return lo;
        
    }

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
