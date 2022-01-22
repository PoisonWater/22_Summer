package Meta;

import java.util.LinkedList;
import java.util.Queue;

// R2
// data 0  1     1 10    1 10 3      5 10 3
// ctr  0  1     2       3 (size)    3           3
// sum  0  1     11      14          
// ptr  0  1     2       0           3

// Array Queue

// Revisit: 现在能用array了 真牛逼！
class MovingAverageR {

    int ptr = 0, ctr = 0;
    double sum = 0;
    int[] data;
    
    public MovingAverageR(int size) {
        data = new int[size];
    }
    
    public double next(int val) {
        // get sum;
        sum += val;
        sum -= data[ptr];
        
        // update data[];
        data[ptr++] = val;
        if (ptr == data.length) { ptr = 0; }
        
        // update ctr;
        if (ctr < data.length) {
            ctr++;
        }
        
        return sum / ctr;
        
    }
}


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
