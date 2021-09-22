import java.util.Arrays;

public class S28 {

    private int[] getNext(String needle) {
        int[] next = new int[needle.length()];
        int j = 0;
        if (needle.length() == 0) {
            return next;
        }
        next[j] = 0;

        for (int i = 1; i < next.length; i++) { // !!! i start at 1, next[0] has been defined
            // 1. While mismatch, backtrace:
            while (j > 0 && needle.charAt(j) != needle.charAt(i)) {
                j = next[j - 1];
            }

            // 2. If match, j++ is the place for checking for the given char. (all chars
            // before j++ is a match.)
            if (needle.charAt(j) == needle.charAt(i))
                j++;

            // 3. Assign j for the prefix at index i (Match -- j+1, NOT Match -- 0)
            next[i] = j;
        }

        return next;

    }

    public int strStr(String haystack, String needle) {

        int[] next = getNext(needle);
        int j = 0;

        // NOTICE extreme cases when needle is "", by definition, index 0 has ""
        // appeared.
        if (next.length == 0) {
            return 0;
        }

        // Similar to implementation in getNext()
        for (int i = 1; i < haystack.length(); i++) { // i start at 0 here

            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }

            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }

            if (j == needle.length()) {
                return i - needle.length() + 1; // Result returns here.
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        S28 test = new S28();
        System.out.println(test.strStr("Hello", "ll"));
        System.out.println(Arrays.toString(test.getNext("abaabaaabaaba")));
    }

}
