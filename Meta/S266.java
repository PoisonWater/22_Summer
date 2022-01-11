package Meta;

public class S266 {

    // Revisited
    
    public boolean canPermutePalindrome(String s) {
        
        int[] map = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }
        
        boolean hasOdd = false;
        
        for (int n : map) {
            if (n % 2 == 0) {
                continue;
            }
            if (hasOdd) {
                return false;
            }
            hasOdd = true;
        }
        
        return true;
        
    }
}
