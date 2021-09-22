import java.util.List;
import java.util.LinkedList;

class S39 {
    public List<List<Integer>> ret = new LinkedList<>();
    public LinkedList<Integer> ans = new LinkedList<>();

    private int sumEval(int target) {
        int sum = 0;

        for (Integer integer : ans)
            sum += integer;

        if (sum == target) {
            return 0;
        } else if (sum > target) {
            return -1;
        } else {
            return 1;
        }
    }

    private void getSum(int[] candidates, int target, int startPos) {

        for (int i = startPos; i < candidates.length; i++) {

            ans.add(candidates[i]);

            int flag = sumEval(target);

            if (flag == 0) {
                ret.add(new LinkedList<>(ans));
            } else if (flag == 1) {
                getSum(candidates, target, i);
            }

            ans.removeLast();

        }

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 输入: candidates = [2,3,6,7], target = 7
        // 输出: [[7],[2,2,3]]

        getSum(candidates, target, 0);

        return ret;

    }

    public static void main(String[] args) {
        S39 s = new S39();
        int[] c = new int[]{2,3,6,7};
        s.combinationSum(c, 7);
    }
}

// class Solution {

//     List<List<Integer>> ans = new ArrayList<List<Integer>>();
//     List<Integer> combine = new ArrayList<Integer>();

//     public List<List<Integer>> combinationSum(int[] candidates, int target) {

//         dfs(candidates, target, 0);
//         return ans;
//     }

//     public void dfs(int[] candidates, int target, int idx) {
//         if (idx == candidates.length) {
//             return;
//         }
//         if (target == 0) {
//             ans.add(new ArrayList<Integer>(combine));
//             return;
//         }
//         // 直接跳过
//         dfs(candidates, target, idx + 1);
//         // 选择当前数
//         if (target - candidates[idx] >= 0) {
//             combine.add(candidates[idx]);
//             dfs(candidates, target - candidates[idx], idx); // 更新target，不重复计算，只比大小
//             combine.remove(combine.size() - 1);
//         }
//     }
// }
