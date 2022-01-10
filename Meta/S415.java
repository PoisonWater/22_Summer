package Meta;

public class S415 {

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
