package Meta;

import java.util.Arrays;
import java.util.PriorityQueue;

// Revisit
// Top K 问题最优解用Quick select -- ON time O1 space
class S973 {

    // Min Heap
    public int[][] kClosest0(int[][] points, int k) {
        
        // Comparator 小于0, ab不交换位置
        // Comparator 大于0, ab交换位置
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0]*a[0] + a[1]*a[1] - (b[0]*b[0] + b[1]*b[1])));
        
        for (int[] e : points) {
            pq.add(e);
        }
        
        // Heap 的实现不一定让整个heap排好序，只能用poll返回有序数组！！！
        int[][] ret = new int[k][2];
        
        for (int i = 0; i < k ; i++) {
            ret[i] = pq.poll();
        }
        
        return ret;
        
    }

    public int[][] kClosest(int[][] points, int K) {
        int i = 0, j = points.length - 1;
        while(i < j) {
            int mid = partition(points, i, j);
            if(mid == K) break;
            if(mid < K) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return Arrays.copyOf(points, K);
    }
    
    private int partition(int[][] points, int start, int end) {
        int[] pivot = points[end];
        int swapIndex = start - 1;
        for(int i = start; i < end; i++) {
            if(value(points[i]) < value(pivot)) {
                swapIndex++;
                swap(points, swapIndex, i);
            }
        }
        swap(points, ++swapIndex, end);
        return swapIndex;
    }
    
    private int value(int[] a) {
        return a[0] * a[0] + a[1] * a[1];
    }
    
    private void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }

//     private void swap(int[][] points, int i1, int i2) {
//         int[] tmp = points[i2];
//         points[i2] = points[i1];
//         points[i1] = tmp;
//     }
    
//     private int dist(int[] p) {
//         return p[0] * p[0] + p[1] * p[1];
//     }
    
//     private int partition(int[][] points, int start, int end) {
        
//         int pivot = dist(points[end]);
//         int swapIndex = -1; // swapindex 及之前是没问题的比 pivot 小的位置
        
//         for (int i = start; i < end - 1; i++) {
//             // swap 的是把小的数字塞到前面
//             if (dist(points[i]) < pivot) {
//                 swap(points, ++swapIndex, i);
//             }
//         }
        
//         // Swap the pivot
//         swap(points, ++swapIndex, end);
        
//         return swapIndex;
        
//     }
    
//     // Quick Select!
//     public int[][] kClosest(int[][] points, int k) {
        
//         int start = 0;
//         int end = points.length - 1;
        
//         while (start < end) {
//             int swap = partition(points, start, end);
//             if (swap == k-1 ) { break; }
//             // if (swap == k) { return Arrays.copyOfRange(points, 0, k-1); }
//             if (swap < k) {
//                 start = swap + 1;
//             } else {
//                 end = swap - 1;
//             }

//         }
        
//         return Arrays.copyOfRange(points, 0, k);
//     }
    
}