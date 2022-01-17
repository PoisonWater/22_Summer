package Meta;

public class S8 {

    // Revisited, TODO: need Rewrite 太繁琐了
    // Simpler handling long integers:
    public static int myAtoi1(String str) {
        if (str == null || str.length() == 0)
            return 0;//
        str = str.trim();
        char firstChar = str.charAt(0);
        int sign = 1, start = 0, len = str.length();
        long sum = 0;
        if (firstChar == '+') {
            sign = 1;
            start++;
        } else if (firstChar == '-') {
            sign = -1;
            start++;
        }
        for (int i = start; i < len; i++) {
            if (!Character.isDigit(str.charAt(i)))
                return (int) sum * sign;
            sum = sum * 10 + str.charAt(i) - '0';
            if (sign == 1 && sum > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (sign == -1 && (-1) * sum < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }
    
        return (int) sum * sign;
    }


    public int myAtoi(String s) {
        // 1. find first index of sign or digit
        int index = 0;
        int sign = 1;
        long ret = 0;
        int ctr = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (Character.isDigit(c) || c == '+' || c == '-') {
                break;
            } 
            if (c == ' ') {
                index++;
            } else {
                return (int)ret;
            }
        }
        
        // 2. keep reading from that index until meeting the first nondigit
        if (index < s.length() && s.charAt(index) == '-') {
            sign = -1;
            index++;
        } else if (index < s.length() && s.charAt(index) == '+') {
            index++;
        }

        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            ret = ret * 10 + (s.charAt(index) - '0');
            index++;
            if (ret != 0) {
                ctr++; // effective digits counter
            }
        }
        
        // Longer than long
        if (ctr > 11) {
            if (sign > 0) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        }
        
        // Out of int range
        if (ret * sign > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (ret * sign < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        // 3. return.
        return (int)ret * sign;
    }
}
