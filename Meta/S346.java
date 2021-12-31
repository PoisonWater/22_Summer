package Meta;

import java.util.LinkedList;
import java.util.Queue;

// 别用Array！其实时间和空间差别不大，自己keep track很容易搞乱pointer
// 注意返回单位是double
class MovingAverage {

    int sum, size;
    Queue<Integer> queue = new LinkedList<>();

    public MovingAverage(int size) {
        this.sum = 0;
        this.size = size;
    }
    
    public double next(int val) {
        // 1. queue
        queue.offer(val);
        if (queue.size() > size) {
            sum -= queue.poll();
        }
        
        // 2. generate sum and avg
        sum += val;
        return (double) sum / queue.size();
    }
}
