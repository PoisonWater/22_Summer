package Meta;

public class S921 {

    public int minAddToMakeValid(String s) {
        
        char[] chars = s.toCharArray();
        int reverse = 0, stackCtr = 0;
        
        for (char c : chars) {
            if (c == '(') {
                stackCtr++;
            } else {
                if (stackCtr == 0) {
                    reverse++;
                } else {
                    stackCtr--;
                }
            }
        }
        
        return reverse + stackCtr;
        
    }
    
}
