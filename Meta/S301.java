package Meta;

import java.util.ArrayList;
import java.util.List;

public class S301 {

    // 太难了啊阿啊阿啊
    // https://www.youtube.com/watch?v=llYfOsGSvdc&ab_channel=AndroidBabies%E5%AE%89%E5%8D%93%E5%A4%A7%E5%AE%9D%E8%B4%9D%E4%BB%AC
    
    List<String> ret = new ArrayList<>();
    
    public List<String> removeInvalidParentheses(String s) {
            
        // 1. Getting the number of l and r INVALID parenthesis
        int l = 0, r = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                l++;
            } else if (c == ')') {
                if (l == 0) { r++; } 
                else { l--; }
            }
        }
        if (l == 0 && r == 0) { 
            ret.add(s);
            return ret; 
        }
        dfs(s, l, r, 0);
        return ret;
    }
    
    private boolean isValid(String s) {
        int l = 0, r = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                l++;
            } else if (c == ')') {
                if (l == 0) { r++; } 
                else { l--; }
            }
        }
        if (l == 0 && r == 0) { return true; }
        return false;
    }
    
    private void dfs(String s, int l, int r, int prev) {
        // 3. judge valid 
        if (l == 0 && r == 0) {
            if (isValid(s)) { ret.add(s); }
            return;
        }
        
        // 2. delete parenthesis 1 at a time
        for (int i = prev; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' && l > 0) {
                dfs(s.substring(0,i) + s.substring(i+1, s.length()), l-1, r, i);
                while (i+1 < s.length() && s.charAt(i+1) == '(') { // Jump through same cases
                    i++;
                }
            } else if (c == ')' && r > 0) {
                dfs(s.substring(0,i) + s.substring(i+1, s.length()), l, r-1, i);
                while (i+1 < s.length() && s.charAt(i+1) == ')') { // Jump through same cases
                    i++;
                }
            }
        }
    }
}
