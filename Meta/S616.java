package Meta;

public class S616 {

    // R2
    public String addBoldTagR2(String s, String[] words) {
        
        boolean[] isBold = new boolean[s.length()]; // char mapped should be bold?
        
        for (String word : words) {
            int ptr = 0;
            if (word.length() == 0) { continue; }
            
            while (ptr < s.length()) {
                // find match
                int match = s.indexOf(word, ptr);
                
                // ptr
                if (match < 0) {
                    break;
                }
                
                // mark bold
                for (int i = 0; i < word.length(); i++) {
                    isBold[match + i] = true;
                }
                
                ptr = match + 1;
            }
            
        }
        
        // return new string
        StringBuilder sb = new StringBuilder();
        boolean inBold = false;
        
        for (int i = 0; i < isBold.length; i++) {
            if (inBold == isBold[i]) {
                sb.append(s.charAt(i));
            } else if (inBold && !isBold[i]) {
                sb.append("</b>");
                sb.append(s.charAt(i));
                inBold = false;
            } else {
                sb.append("<b>");
                sb.append(s.charAt(i));
                inBold = true;
            }
        }
        
        if (inBold) {
            sb.append("</b>");
        }
        
        return sb.toString();
    
    }

    // Revisited
    public String addBoldTag(String s, String[] words) {
        int slen = s.length();
        boolean[] isBold = new boolean[slen];
        
        // match each word to s
        for (String word : words) {
            int index = 0, wordlen = word.length();
            
            // match the word to all indexes
            while (index + wordlen <= slen) {
                int match = s.indexOf(word, index);
                
                // find match
                if (match >= 0) {
                    // update bold
                    for (int i = 0; i < wordlen; i++) {
                        isBold[match + i] = true;
                    }
                    index = match + 1;
                } else {
                    index = slen;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        boolean inBold = false;
        
        for (int i = 0; i < slen; i++){
            if ((inBold && isBold[i]) || (!inBold && !isBold[i])) {
                sb.append(s.charAt(i));
            } else if (!inBold && isBold[i]) {
                inBold = true;
                sb.append("<b>");
                sb.append(s.charAt(i));
            } else {
                inBold = false;
                sb.append("</b>");
                sb.append(s.charAt(i));
            }
        }
        
        if (inBold) {
            sb.append("</b>");
        }
        
        return sb.toString();
        
    }
}
