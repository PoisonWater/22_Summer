package Meta;

class S408R {

    // R2 TODO REDO 
    public boolean validWordAbbreviationR2(String word, String abbr) {
        int pword = 0, pabbr = 0, num = 0;
        
        while (pword < word.length() && pabbr < abbr.length()) {
            
            char cw = word.charAt(pword), ca = abbr.charAt(pabbr);
            
            // 1. number in pabbr
            if (Character.isDigit(ca)) {
                // 1.1 leading 0
                if (ca == '0') {
                    return false;
                }
                
                // 1.2 get number
                num = 0;
                // 注意 用pointer更直观！！！不要读出来再increment！因为要不断在当前for loop中while loop
                while (pabbr < abbr.length() && Character.isDigit(abbr.charAt(pabbr))) {
                    num = (abbr.charAt(pabbr++) - '0') + 10 * num;
                }
                
                // 1.3 add to pword
                pword += num;
                
            } else {
                if (cw != ca) {
                    return false;
                }
                pword++;
                pabbr++;
            }
            
        }
        
        return pword == word.length() && pabbr == abbr.length();
        
    } 

    public boolean validWordAbbreviation(String word, String abbr) {
        
        int wPtr = 0, aPtr = 0, ctr = 0;
        
        while (wPtr < word.length() && aPtr < abbr.length()) {
            char wc = word.charAt(wPtr), ac = abbr.charAt(aPtr);
            
            // Digits:
            // leading 0:
            if (ctr == 0 && ac == '0') {
                return false;
            }
            if (Character.isDigit(ac)) {
                while (Character.isDigit(ac)) {
                    ctr = 10 * ctr + (ac - '0');
                    if (++aPtr < abbr.length()) {
                        ac = abbr.charAt(aPtr);
                    } else {
                        // 注意终止为数字的结束条件!
                        break; // break 该 while loop，在后面又给wptr加ctr了
                    }
                }
                wPtr += ctr;
                ctr = 0; // 别忘归0
                continue;
            }
            
            if (wc != ac) {
                return false;
            }
            wPtr++;
            aPtr++;
        }
        
        return wPtr == word.length() && aPtr == abbr.length();
        
    }
}

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
