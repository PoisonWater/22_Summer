package Meta;

// revisit - 写复杂了 重复利用代码也行 原来写得好
class S680Revisit {
    boolean second = false;
    
    public boolean validPalindrome(String s) {
        int len = s.length();
        for (int i = 0; i <= len / 2; i++) {
            char c0 = s.charAt(i), c1 = s.charAt(len - i - 1);
            if (c1 != c0) {
                if (second) {
                    return false;
                }
                second = true; // 别忘设置条件 其实直接写两个function最好 不会忘
                return validPalindrome(s.substring(0,i) + s.substring(i+1)) || 
                    validPalindrome(s.substring(0,len - i - 1) + s.substring(len - i));
            }
        }
        return true;
    }
}

public class S680 {
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l<r && s.charAt(l) == s.charAt(r)) {
            l++;
            r--;
        }
        if (l >= r) {
            return true;
        }
        return validPalindromeHandler(s, l+1, r) || validPalindromeHandler(s, l, r-1);
    }
    
    public boolean validPalindromeHandler(String s, int l, int r) {
        while (l<r && s.charAt(l) == s.charAt(r)) {
            l++;
            r--;
        }
        return l >= r;
    }
    
    // ON Time O1 Space
}
