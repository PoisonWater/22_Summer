class S459 {

    //// BRUTAL FORCE: // Takes much longer time

    // public boolean repeatedSubstringPattern(String s) {

    //     for (int i = 1; i < s.length(); i++) {
    //         if ((s+s).substring(i, i+s.length()).equals(s)) return true;
    //     }

    //     return false;
    // }


    //// KMP Finding inate string orders.

    private int[] getNext(String pattern) {

        int[] next = new int[pattern.length()];
        int j = 0;
        next[j] = 0;

        for (int i = 1; i < next.length; i++) {
            // 1. Get matching index of j
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = next[j-1];
            }

            // 2. Check char #i == char #j
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
            }

            // 3. Assign value for next[i]
            next[i] = j;
        }
        
        return next;
    }
    
    public boolean repeatedSubstringPattern(String s) {

        int[] prefixTable = getNext(s);
        int len = prefixTable.length;

        // Divisible
        if (prefixTable[len-1] > 0 && len % (len - prefixTable[len-1]) == 0) { // TODO: Judgement procedure?
            return true;
        }

        return false;

    }

    public static void main(String[] args) {
        S459 t = new S459();
        System.out.println(t.repeatedSubstringPattern("aaaa"));

    }

}