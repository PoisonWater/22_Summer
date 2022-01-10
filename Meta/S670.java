package Meta;

public class S670 {

    // Revisit
    public int maximumSwap1(int num) {
        // Last Index:
        char[] numChars = String.valueOf(num).toCharArray();
        int[] last = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        for (int i = 0; i < numChars.length; i++) {
            last[numChars[i] - '0'] = i;
        }
        int[] first = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        for (int i = numChars.length-1; i >= 0; i--) {
            first[numChars[i] - '0'] = i;
        }
        
        // swap biggest number with the frontest number smaller than it
        int ind;
        for (int i = 9; i >= 0; i--) {
            if (last[i] == -1) {
                continue;
            }
            ind = last[i];
            for (int j = i-1; j >= 0; j--) {
                if (first[j] == -1) {
                    continue;
                }
                if (first[j] < ind) {
                    ind = first[j];
                }
            }
            if (ind < last[i]) {
                char tmp = numChars[ind];
                numChars[ind] = numChars[last[i]];
                numChars[last[i]] = tmp;
                return Integer.parseInt(String.valueOf(numChars));
            }
        }
        
        return num;
        
    }

    // 后面有更繁琐但更直观的解释

    // Similar but simpler idea:
    // Use buckets to record the LAST position of digit 0 ~ 9 in this num.

    // Loop through the num array from left to right. 
    // For each position, we check whether there exists a LARGER digit in this num (start from 9 to current digit). 
    // We also need to make sure the position of this larger digit is BEHIND the current one. 
    // If we find it, simply swap these two digits and return the result.

    public int maximumSwap0(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        
        int[] buckets = new int[10];
        for (int i = 0; i < digits.length; i++) {
            buckets[digits[i] - '0'] = i;
        }
        
        for (int i = 0; i < digits.length; i++) {
            for (int k = 9; k > digits[i] - '0'; k--) {
                if (buckets[k] > i) {
                    char tmp = digits[i];
                    digits[i] = digits[buckets[k]];
                    digits[buckets[k]] = tmp;
                    return Integer.valueOf(new String(digits));
                }
            }
        }
        
        return num;
    }


    
    public int maximumSwap(int num) {
        char[] cnum = String.valueOf(num).toCharArray();
        
        // 如果存在，用最后一个最大的数(942388的后一个8)，换取其之前最前的小于他的数(942388的后一个8 换 小于8的4，不能换9)
        int[] occurLast = new int[10]; //  存各个数字最后一次出现index
        int[] occurFirst = new int[10]; // 存各个数字最前一次出现index
        for (int i = 0; i < 10; i++) {
            occurLast[i] = -1;
            occurFirst[i] = -1;
        }
        
        for (int i = 0; i < cnum.length; i++) {
            int currInt = cnum[i] - '0';
            if (occurFirst[currInt] == -1) {
                occurFirst[currInt] = i;
            }
            occurLast[currInt] = i;
        }
        
        int minIndex = Integer.MAX_VALUE; 
        for (int i = 9; i >= 0; i--) { // last 找 有在其之前小于他的数 的 最后一个最大的数
            minIndex = Integer.MAX_VALUE;
            if (occurLast[i] == -1) {
                continue;
            }
            
            for (int j = 0; j < i; j++) { // First 找 最后一个最大的数 之前 小于他的最前面的数
                if (occurFirst[j] != -1) {
                    minIndex = Math.min(occurFirst[j], minIndex);
                }
            }
            
            if (minIndex < occurLast[i]) {
                // swap and return
                char tmp = cnum[minIndex];
                cnum[minIndex] = cnum[occurLast[i]];
                cnum[occurLast[i]] = tmp;
                return Integer.parseInt(String.valueOf(cnum));
            }
        }
        
        return Integer.parseInt(String.valueOf(cnum));
        
    }
}
