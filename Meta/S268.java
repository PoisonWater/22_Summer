package Meta;

public class S268 {
    public int missingNumber(int[] nums) {
        int expSum = (nums.length * (nums.length + 1)) / 2;
        int actSum = 0;
        for (int i : nums) {
            actSum += i;
        }
        return expSum - actSum;
    }
}
