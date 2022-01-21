package Meta;

public class S921 {

    // R2
    public int minAddToMakeValidR(String s) {
        int l = 0, r = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (l == 0) {
                    r++;
                } else {
                    l--;
                }
            } else if (c == '(') {
                l++;
            }
        }
        return l + r;
    }

    public int minAddToMakeValid(String s) {
        
        char[] chars = s.toCharArray();
        // Revisit: 两边的parenthesis各一个stack ptr
        int reverse = 0, stackCtr = 0;
        
        for (char c : chars) {
            if (c == '(') {
                stackCtr++;
            } else {
                if (stackCtr == 0) {
                    reverse++;
                } else {
                    stackCtr--;
                }
            }
        }
        
        return reverse + stackCtr;
        
    }
    
}
