package Twitter;
// SKIPPED
// https://leetcode.com/discuss/interview-question/376019/Twitter-or-OA-2019-or-Autoscale-Policy
class AutoscalePolicy {
    public int finalinstances(int instances, int[] A) {
        int idle = 10, i = 0, n = A.length;
        int r = (int) (1e8);
        double ans = instances;
        while (i < n) {
            if (A[i] < 25 && ans > 1) {
                ans = (int) Math.ceil(ans / 2);
                i = i + idle;
            } else if (A[i] > 60 && A[i] <= r) {
                ans *= 2;
                i = i + idle;
            }
            i++;
        }
        return (int) ans;
    }
}

class Main {
    public static void main(String[] args) {
        int instances = 1;
        int[] A = { 5, 10, 80 };
        System.out.println(new AutoscalePolicy().finalinstances(instances, A));
    }
}
