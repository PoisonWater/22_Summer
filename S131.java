import java.util.LinkedList;
import java.util.Arrays;
import java.util.List;

class S131 {
    List<List<String>> ans = new LinkedList<>();
    LinkedList<String> stack = new LinkedList<>();

    private boolean isPalindrome(char[] s, int startIndex, int stopIndex) {
        char[] chars = Arrays.copyOfRange(s, startIndex, stopIndex+1);
        for (int i = 0; i < chars.length/2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    private void getPartition(char[] chars, int startPos) {

        for (int i = startPos; i < chars.length; i++) {
            // Check current palindrome
            if (isPalindrome(chars, startPos, i)) {
                if (i == chars.length - 1) {
                    // Reaches End, Add to ans
                    String charscopy = new String(Arrays.copyOfRange(chars, startPos, i+1));
                    stack.add(charscopy);
                    ans.add(new LinkedList<>(stack));
                    stack.removeLast();
                } else {
                    String charscopy = new String(Arrays.copyOfRange(chars, startPos, i+1));
                    stack.add(charscopy);
                    getPartition(chars, i+1);
                    stack.removeLast();
                }
            }
        }
    }

    public List<List<String>> partition(String s) {
        char[] chars = s.toCharArray();

        getPartition(chars, 0);

        return ans;
    }
    public static void main(String[] args) {
        S131 a = new S131();
        List<List<String>> s = a.partition("aab");
        for (List<String> list : s) {
            for (String st : list) {
                System.out.println(st);
            }
        }
        // System.out.println("OK");
    }

}