package Meta;

import java.util.Arrays;
import java.util.Comparator;

public class S791 {

    // 用计数重构方法更简单
    // 建立s的计数map 再根据order读取map 输出StringBuilder
    public String customSortString1(String order, String s) {
        int[] ctr = new int[26]; // 字母题可以用arr代替hashmap
        
        // count characters in counter
        for (char c : s.toCharArray()) {
            ctr[c - 'a'] += 1;
        }
        
        // reconstruct sorted
        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()) {
            while (ctr[c - 'a'] > 0) {
                ctr[c - 'a']--;
                sb.append(c);
            }
        }
        
        // not in "order" str
        for (int i = 0; i < 26; i++) {
            while (ctr[i] > 0) {
                ctr[i]--;
                sb.append((char)(i + 'a'));
            }
        }
        
        return sb.toString();
        
    }

    public String customSortString(String order, String s) {
        // s as char array
        Character[] cs = new Character[s.length()];
		for (int i = 0; i < s.length(); ++i)
			cs[i] = s.charAt(i);

        // 另一种写法
        Arrays.sort(cs, new Comparator<Character>() {
            @Override
            public int compare(Character a, Character b) {
                if (order.indexOf(a) == -1 || order.indexOf(a) == -1) {
                    return -1;
                }
                return order.indexOf(a) - order.indexOf(b);
            }
        });
        
        // Comparator 不可以接 Primitive type！
        Arrays.sort(cs, (a, b) -> {
            if (order.indexOf(a) == -1 || order.indexOf(a) == -1) {
                return -1;
            }
            return order.indexOf(a) - order.indexOf(b);
        });
        
        StringBuilder sb = new StringBuilder(cs.length); 
        for (Character c : cs) 
            sb.append(c.charValue()); 
  
        return sb.toString();
    }
}
