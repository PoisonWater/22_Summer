package Meta;

//Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

/*
[1,4,5,7]
return:
[1,16,25,49]

          |   
[-5, -3, -1, 0, 0, 1, 2, 4]

[,                      ,25]

[]

[0]

 */

class Sol01 {
    public int[] solution(int[] arr) {

        // corner case
        if (arr.length == 0) {return null;}
        
        // 2 ptrs
        int p1 = 0, p2 = arr.length - 1; //0 3
        int[] ret = new int[arr.length];

        // fill in ret
        int ptr = arr.length - 1;
        while (ptr >= 0) {

            // 0
            // |

            // compare between 2 pointed values
            int num1 = arr[p1], num2 = arr[p2]; // 1 4

            if (Math.abs(num1) < Math.abs(num2)) {
                ret[ptr] = num2*num2;
                p2--;
            } else {
                ret[ptr] = num1 * num1;
                p1++;
            }

            ptr--;
        }

        return ret;

    }
}



/*
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
*/

//   4 3 1 2 5 8 7 9
// l         |
// r               |

class Sol02 {

    private int distOf(int[][] points, int i) {
        return (points[i][0] * points[i][0]) + (points[i][1] * points[i][1]);
    }

    private void partition(int[][] points, int start, int end, int k ) {

        // termination
        if (start >= end) {
            return Arrays.copyOf(points, 0, k);
        }

        int p1 = 0, p2 = 0;
        int pivotDist = distOf(points, end);
        //[0, p1]: for ele < pivotDist

        for (; p2 < end; p2++) {
            
            int dist = distOf(points, p2);
            
            // dist < pivot
            if (dist < pivotDist) {
                swap(points, p1++, p2);
            }
        }
        swap(points, p1, p2);

        if (p1 == k) { return; }

        if (p1 < k) {
            partition(points, p1 + 1, end, k);
        } else {
            partition(points, start, p1 - 1, k);
        }



    }

    public int[][] kClosest(int[][] points, int k) {
        // 
        partition(points, 0, points.length - 1, k - 1);

        return Arrays.copyOf();

    }

}

