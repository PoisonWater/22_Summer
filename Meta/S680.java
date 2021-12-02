package Meta;

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
