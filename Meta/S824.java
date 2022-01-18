package Meta;

public class S824 {
    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            
            // vowel?
            char c = word.charAt(0);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' 
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                sb.append(word);
                sb.append("ma");
            } else {
                // cons reform
                sb.append(word.substring(1));
                sb.append(c);
                sb.append("ma");
            }
            
            // add 'a'
            for (int j = 0; j < i + 1; j++) {
                sb.append('a');
            }
 
            // add a according to index
            sb.append(' ');            
            
        }
        
        sb.deleteCharAt(sb.length() - 1);
        
        return sb.toString();
        
    }
}
