package Meta;

public class S616 {

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
