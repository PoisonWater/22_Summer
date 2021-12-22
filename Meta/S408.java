package Meta;

public class S408 {

    // Simpler two pointer + while approach
    public boolean validWordAbbreviation(String word, String abbr) {

        // i for word, j for abbr
        int i = 0, j = 0;

        
        while (i < word.length() && j < abbr.length()) {
            // 1. 均为字母
            if (word.charAt(i) == abbr.charAt(j)) {
                ++i;++j;
                continue;
            }
            if (abbr.charAt(j) <= '0' || abbr.charAt(j) > '9') {
                return false;
            }

            // 2. abbr 为 num, 一次性把数字处理完加到 i 和 j ptr；
            int start = j;
            while (j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                ++j;
            }
            int num = Integer.valueOf(abbr.substring(start, j));
            i += num;
            
        }

        // 返回是否同时到达最后长度
        return i == word.length() && j == abbr.length();
    }

    public boolean validWordAbbreviation0(String word, String abbr) {
        
        int num = 0, d = 0, j = 0, i = 0, dsum = 0, numsum = 0;
        char[] abb = abbr.toCharArray();
        
        for (i = 0; i < abb.length; i++) {
            
            // 1. Char at i is letter;
            if (!(abb[i] >= '0' && abb[i] <= '9')) {
                
                if (d != 0) {
                    dsum += d;
                    numsum += num;
                    d = 0;
                    num = 0;
                    j = i - dsum + numsum;
                }
                
                if (j >= word.length() || word.charAt(j) != abb[i]) {
                    return false;
                }
                j++;
                continue;
            }
            
            // 2. Char at i is NUMBER:
            // 2.1 Previous num?
            if (num == 0 && abb[i] == '0') { return false; }
            
            // 2.2 normal num
            num = 10 * num + (abb[i] - '0');
            d++;
            
        }
        
        if (d != 0) {
            dsum += d;
            numsum += num;
            d = 0;
            num = 0;
            j = i - dsum + numsum;
        }
        
        return j == word.length();
        
    }
}
