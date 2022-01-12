package Meta;
// interface BinaryMatrix {
//     public int get(int row, int col) {}
//     public List<Integer> dimensions {}
// };

// Revisit: TODO: Rewrite
// 这次变量考虑不好 没有选好变量 再做一次！
class S1428R {
    private int binSearch(BinaryMatrix bm, int row, int end) {
        int lo = 0, hi = end;
        if (bm.get(row, end) == 0) {
            return -1;
        }
        
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (bm.get(row, mid) == 0) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }
    
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int rows = binaryMatrix.dimensions().get(0);
        int col = binaryMatrix.dimensions().get(1) - 1;
        
        // 注意考虑return -1的corner case - 全是0
        boolean found = false;
        
        for (int i = 0; i < rows; i++) {
            int res = binSearch(binaryMatrix, i, col);
            // 注意：Termination：col = 0:
            if (res == 0) { return 0; }
            
            found = res == -1 ? found : true; // corner case
            col = res == -1 ? col : res - 1;
        }
        
        return found ? col + 1 : -1;
    }
}


public class S1428 {
    // https://leetcode.com/problems/leftmost-column-with-at-least-a-one/solution/
    // Binary Search row by row
    // OM+N time O1 space
    // Slower than general binary search O NLogM when M is very large
    private int binSearch(BinaryMatrix bm, int high, int row) {
        int lo = 0, hi = high;
        if (bm.get(row, hi) == 0) { return -1; }
        
        while (lo <= hi) {
            
            int mid = (hi + lo) / 2;
            if (bm.get(row, mid) == 0) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        
        return lo; // return index of leftmost 1
        
    }
    
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        
        boolean found = false;
        
        int rows = binaryMatrix.dimensions().get(0), cols = binaryMatrix.dimensions().get(1);
        int hi = cols - 1;
        
        // binSearch row by row
        for (int row = 0; row < rows; row++) {
            int tmp = binSearch(binaryMatrix, hi, row);
            if (tmp != -1) {
                hi = tmp - 1;
                if (hi < 0) {return 0;}
                found = true;
            }
        }
        
        // Return 
        if (found) {
            return hi + 1;
        } else {
            return -1;
        }
    }

    // Binary Search General
    // Let N be the number of rows, and M be the number of columns
    // Time complexity: O(NlogM). Space complexity: O(1).
    public int leftMostColumnWithOne1(BinaryMatrix binaryMatrix) {
        int rows = binaryMatrix.dimensions().get(0);
        int cols = binaryMatrix.dimensions().get(1);
        int smallestIndex = cols;
        for (int row = 0; row < rows; row++) {
            // Binary Search for the first 1 in the row.
            int lo = 0;
            int hi = cols - 1;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (binaryMatrix.get(row, mid) == 0) {
                    lo = mid + 1;
                }
                else {
                    hi = mid;
                }
            }
            // If the last element in the search space is a 1, then this row
            // contained a 1.
            if (binaryMatrix.get(row, lo) == 1) {
                smallestIndex = Math.min(smallestIndex, lo);
            }
        }
        // If smallest_index is still set to cols, then there were no 1's in 
        // the grid. 
        return smallestIndex == cols ? -1 : smallestIndex;
    }
}
