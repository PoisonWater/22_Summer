package Meta;

public class S953 {

    // Revisited
    private boolean isSorted(String w1, String w2, String order) {
        for (int i = 0; i < w1.length() && i < w2.length(); i++) {
            if (order.indexOf(w1.charAt(i)) < order.indexOf(w2.charAt(i))) {
                return true;
            }
            if (order.indexOf(w1.charAt(i)) > order.indexOf(w2.charAt(i))) {
                return false;
            }
        }
        return w1.length() <= w2.length(); // 只有全等才会判断length
    }
    
    public boolean isAlienSorted(String[] words, String order) {
        
        if (words.length <= 1) {
            return true;
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            if (!isSorted(words[i], words[i+1], order)) {
                return false;
            }
        }
        
        return true;
    }

}
