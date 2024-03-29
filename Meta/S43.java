package Meta;

public class S43 {

    // R2
    // https://leetcode.com/problems/multiply-strings/discuss/17605/Easiest-JAVA-Solution-with-Graph-Explanation
    public String multiplyR2(String num1, String num2) {
    
        int len1 = num1.length(), len2 = num2.length(); 
        int[] steps = new int[len1 + len2]; // storing values at each indicies
        
        // structing steps
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                steps[i + j] += (num1.charAt(len1 - 1 - i) - '0') * (num2.charAt(len2 - 1 - j) - '0');
            }
        }
        
        // return
        int curr = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < steps.length; i++) {
            curr += steps[i];
            sb.append(curr % 10);
            curr /= 10;
        }
        
        // Format
        sb.reverse();
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        
        return sb.toString();
        
    }
    
    private void addChar(char[] result, char[] add, int index) {
        int carry = 0, lenR = result.length, i;
        for (i = 0; i < add.length; i++) {
            char cR = result[lenR - 1 - index - i], cA = add[add.length - 1 - i];
            int bit = (cR - '0') + (cA - '0') + carry;
            result[lenR - 1 - index - i] = (char) (bit % 10 + '0');
            carry = bit / 10;
        }
        
        while (carry != 0) {
            char cR = result[lenR - 1 - index - i];
            int bit = (cR - '0') + carry;
            result[lenR - 1 - index - i] = (char) (bit % 10 + '0');
            carry = bit / 10;
            i++;
        }
    }
    
    public String multiply(String num1, String num2) {
        
        int len1 = num1.length(), len2 = num2.length(), len = len1 + len2;
        char[] result = new char[len];
        for (int i = 0; i < len; i++) {
            result[i] = '0';
        }
        
        for (int j = 0; j < len2; j++) {
            char[] bitResult = new char[len1 + 1];
            for (int i = 0; i <= len1; i++) {
                bitResult[i] = '0';
            }
            int carry = 0;
            for (int i = 0; i < len1; i++) {
                char c1 = num1.charAt(len1 - 1 - i), c2 = num2.charAt(len2- 1- j);
                int bit = (c1 - '0') * (c2 - '0') + carry;
                bitResult[len1 - i] = (char) (bit % 10 + '0');
                carry = bit / 10;
            }
            bitResult[0] = (char) (carry + '0');
            
            addChar(result, bitResult, j);
        }
        
        // Find first non zero
        int i = 0;
        while (i < len && result[i] == '0') {
            i++;
        }
        if (i == len) { return "0"; } // result is 0

        return String.valueOf(result).substring(i);
    }
}
