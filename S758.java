// SAME AS S616

class S758 {
    
    public String boldWords(String[] words, String s) {
        
        // Finding the BOLD Characters
        boolean[] isBold = new boolean[s.length()];
        
        for (String pattern : words) {
            
            int indexPat = s.indexOf(pattern);
        
            while (indexPat != -1) {
                                
                for (int i = 0; i < pattern.length(); i++) {
                    isBold[i + indexPat] = true;
                }
                
                indexPat = s.indexOf(pattern, indexPat + 1);
                
            }
            
        }  
        
        // Generating output
        StringBuilder sb = new StringBuilder();
        boolean isBoldBefore = false;
        
        for (int i = 0; i < isBold.length; i++) {
            
            if (isBoldBefore && !isBold[i]) {
                sb.append("</b>");
            } else if (!isBoldBefore && isBold[i]) {
                sb.append("<b>");
            }
            
            sb.append(s.substring(i, i+1));
            
            isBoldBefore = isBold[i];
                
        }
        
        if (isBoldBefore) { sb.append("</b>"); }
        
        return sb.toString();
        
    }
}