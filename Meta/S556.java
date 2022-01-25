package Meta;

public class S556 {
    // R2
    // 123[4]6[5]43 - find first ascending; find smallest bigger element after 'a'
    // 123[5]6[4]43 - swap
    // 123[5][3446] - reverse sub sequence
    
    // 注意考虑全等情况！！
    private int findAsc(char[] num) {
        int ptr = num.length - 1;
        while (ptr >= 1 && num[ptr-1] >= num[ptr]) { // 注意等于情况!
            ptr--;
        }
        return ptr - 1;
    }
    
    private int findLarger(char[] num, int start) {
        char target = num[start++];
        int i;
        for (i = start; i < num.length && num[i] > target; i++) {}
        return i - 1;
    }
    
    private void swap(char[] num, int lo, int hi) {
        char tmp = num[lo];
        num[lo] = num[hi];
        num[hi] = tmp;
    }
    
    private void reverse(char[] num, int lo) {
        int hi = num.length - 1;
        while (lo < hi) {
            swap(num, lo++, hi--);
        }
    }
    
    public int nextGreaterElement(int n) {
        char[] num = String.valueOf(n).toCharArray();
        
        // find first ascending;
        int ascIndex = findAsc(num);
        if (ascIndex == -1) { return -1; }
        
        // find smallest bigger element after ascIndex
        int swapInd = findLarger(num, ascIndex);
        swap(num, swapInd, ascIndex);
        
        // reverse
        reverse(num, ascIndex + 1);
        
        // Handle 超 int range 情况
        try {
            return Integer.parseInt(String.valueOf(num));
        } catch (Exception e) {
            return -1;
        }
        
    }
}
