
import java.util.Set;
import java.util.List;
import java.util.HashSet;

class S139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        
        // 1D-Array for DP
        boolean dp[] = new boolean[s.length() + 1];
        
        // init
        dp[0] = true;
        
        // 完全背包问题
        // 注意遍历顺序：在每个背包iteration中遍历所有item可能性，因为完全背包可放回！！
        // 不可放回的0-1背包则需要翻过来，在每次添加item可能性中遍历一次背包。
        // 注意dp数组形式：完全背包应使用1D-Array，因为不然会有两份不同步的背包copy
        for (int i = 1; i < s.length() + 1; i++) { // space in the backpack 
            for (int j = wordDict.size(); j > 0; j--) { // all items in dict
                if (i-wordDict.get(j - 1).length() >= 0 && dp[i-wordDict.get(j - 1).length()]) {
                    dp[i] = dp[i] || wordDict.get(j - 1).equals(s.substring(i - wordDict.get(j - 1).length(), i));
                }
            }
        }
        
        return dp[s.length()];
    }

    // Faster: HashSet for Search
    public boolean wordBreakFaster(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
    // Time O(n^2), space O(n)


    
    // public static void main(String[] args) {

    //     S139 n = new S139();

    //     LinkedList<String> linkedList = new LinkedList<>();
    //     linkedList.add("a");
    //     linkedList.add("aa");
    //     linkedList.add("aaa");
    //     linkedList.add("aaaa");
    //     linkedList.add("aaaaa");
    //     linkedList.add("aaaaaa");
    //     linkedList.add("aaaaaaa");

    //     boolean retur = n.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", linkedList);
    //     // boolean retur = n.wordBreak("aaaaaaab", linkedList);
    //     System.out.println(retur);
    // }

}