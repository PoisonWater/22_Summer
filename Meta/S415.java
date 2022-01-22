package Meta;

import java.util.Arrays;

public class S415 {

    // R2
    public String addStringsR2(String num1, String num2) {
        char[] ret = new char[num1.length() + num2.length()];
        
        int p = 0, len1 = num1.length(), len2 = num2.length();
        int carry = 0, pret = ret.length - 1;
        
        // Matching part
        while (p < num1.length() && p < num2.length()) {
            
            // curr digits
            char c1 = num1.charAt(len1 - 1 - p), c2 = num2.charAt(len2 - 1 - p);
            
            // update carry and ret;
            ret[pret--] = (char) ((((c1 - '0') + (c2 - '0') + carry) % 10) + '0');
            carry = ((c1 - '0') + (c2 - '0') + carry) / 10;
             
            p++;
        }
        
        // Unmatched part
        while (p < num1.length()) {
            // curr digits
            char c1 = num1.charAt(len1 - 1 - p);
            
            // update carry and ret;
            ret[pret--] = (char) ((((c1 - '0') + carry) % 10) + '0');
            carry = ((c1 - '0') + carry) / 10;
             
            p++;
        }
        
        while (p < num2.length()) {
            // curr digits
            char c1 = num2.charAt(len2 - 1 - p);
            
            // update carry and ret;
            ret[pret--] = (char) ((((c1 - '0') + carry) % 10) + '0');
            carry = ((c1 - '0') + carry) / 10;
             
            p++;
        }
        
        // first digit
        ret[pret] = (char) (carry + '0');
        
        while (pret < ret.length && ret[pret] == '0') { pret++; }
        
        if (pret == ret.length) { return "0"; }
        
        return String.valueOf(Arrays.copyOfRange(ret, pret, ret.length));
        
    }

    // Revisited
    public String addStrings(String num1, String num2) {
        
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        int c1len = c1.length, c2len = c2.length;
        
        char[] co = new char[Math.max(c1len, c2len)];
        int max = Math.max(c1len, c2len);
        int min = Math.min(c1len, c2len);
        
        int ptr = 1, carry = 0;
        
        while (ptr <= max) {
            
            char curr; // current result;
            
            if (ptr > min) {
                
                if (c1len < c2len) {
                    curr = (char)((int)(c2[c2len-ptr]- '0' + carry) + '0');
                } else {
                    curr = (char)((int)(c1[c1len-ptr]- '0' + carry) + '0');
                }
                
            } else {
                curr = (char)((int)(c1[c1len-ptr] + c2[c2len-ptr] - '0' - '0' + carry) + '0');
            }
            
            // Calculate carry
            if (curr > '9') {
                curr = (char)(curr - 10);
                carry = 1;
            } else {
                carry = 0;
            }
            
            // Assignment
            co[co.length - ptr] = curr;
            ptr++;
            
        }
        
        if (carry == 1) {
            return "1" + String.valueOf(co);
        }
        return String.valueOf(co);
    }
    
}
