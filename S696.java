public class S696 {

    public int countBinarySubstring(String s) {
        int ptr = 0, len = s.length(), prev = 0, ret = 0;
        char c;

        while (ptr < len) {
            c = s.charAt(ptr);
            int count = 0;
            while (ptr < len && c == s.charAt(ptr)) {
                count++;
                ptr++;
            }
            ret += Math.min(count, prev);
            prev = count;
        }

        return ret;

    }

}
