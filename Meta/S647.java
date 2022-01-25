package Meta;

public class S647 {

    // R2
    // Revisit
    // TODO: Minor Rewrite
    public int countSubstringsR(String s) {
        int count = 0;
        
        if (s.length() == 1) {return 1;}
        
        count += countSum(s, 0, 0);
        for (int i = 1; i < s.length(); i++) {
            count += countSum(s, i, i);
            count += countSum(s, i-1, i);
        }
        return count;
    }

    // expand around center
    private int countSum(String s, int lo, int hi) {
        int ctr = 0;
        
        while (lo >= 0 && hi < s.length() && s.charAt(lo--)==s.charAt(hi++)) {
            ctr++;
        }
        
        return ctr;
    }

    // https://leetcode.com/problems/palindromic-substrings/discuss/105688/Very-Simple-Java-Solution-with-Detail-Explanation
    // traverse each character and expand to palindrome - ON^2 time O1 space
    public int countSubstrings(String s) {
        int sum = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            sum += checkExp(s, i, i);
            sum += checkExp(s, i, i+1);
        }
        sum += 1; // last odd count is definitely 1;
        return sum;
    }
    
    // specifying lo and hi can check both odd num and even num of chars
    private int checkExp(String s, int lo, int hi) {
        int lclSum = 0;
        while (lo >= 0 && hi < s.length()) {
            if (s.charAt(lo--) != s.charAt(hi++)) {
                return lclSum;
            }
            lclSum++;
        }
        return lclSum;
    }
}
