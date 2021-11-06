// https://leetcode.com/discuss/interview-question/374446/Twitter-or-OA-2019-or-Efficient-Job-Processing-Service

public class JobProcessing {

    public int maximumTotalWeight(int[] weights, int[] tasks, int p) {

        int[] dp = new int[p/2 + 1]; // May define item = weight.length, pPigeon = p/2;

        for (int i = 1; i < weights.length + 1; i++) { // item number
            for (int j = p/2; j > 0; j--) { // knapsack capacity
                if (j - tasks[i-1] >= 0) {
                    dp[j] = Math.max(dp[j], dp[j - tasks[i-1]] + weights[i - 1]);
                }
            }
        }

        return dp[p/2];

    }

    public static void main(String[] args) {
        int[] weights = new int[]{2, 4, 4, 5};
        int[] tasks = new int[]{2, 2, 3, 4};
        System.out.println(new JobProcessing().maximumTotalWeight(weights, tasks, 15));      // 10

        weights = new int[]{2, 2, 4, 5};
        tasks = new int[]{2, 2, 3, 4};
        System.out.println(new JobProcessing().maximumTotalWeight(weights, tasks, 15));      // 9

        weights = new int[]{2};
        tasks = new int[]{2};
        System.out.println(new JobProcessing().maximumTotalWeight(weights, tasks, 1));      // 0

        weights = new int[]{2};
        tasks = new int[]{2};
        System.out.println(new JobProcessing().maximumTotalWeight(weights, tasks, 10));      // 2
    }
}
