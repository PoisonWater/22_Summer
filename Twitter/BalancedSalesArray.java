import java.util.List;

public class BalancedSalesArray {
    public static int balancedSum(List<Integer> arr) {
        int sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
        }
        int left = 0;
        for (int i = 0; i < arr.size(); i++) {
            int right = sum - left - arr.get(i);
            if (left == right)
                return i;
            left += arr.get(i);
        }
        return -1;
    }
}
