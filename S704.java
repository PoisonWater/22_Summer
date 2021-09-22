public class S704 {

    public int search(int[] nums, int target) {
        int up = nums.length -1;
        int lo = 0;
        int mid = up / 2;

        while (up >= lo) {
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                lo = mid + 1;
                mid = (lo + up) /2;
            } else if (target < nums[mid]) {
                up = mid - 1;
                mid = (lo + up) /2;
            }
        }
        
        return -1;
    }

}
