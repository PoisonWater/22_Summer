package placementExam;
public class asdfg {
    public static void main(String args[] ) throws Exception {

        String raw = "baaaaaaabaaaaaab";
        char[] retChar = new char[raw.length()];
        
        // String Handling

        for (int i = 0; i < raw.length()-1; i++) {
            int offset = 1;
            if (raw.charAt(i) == raw.charAt(i+1)) {
                retChar[i] = Character.toUpperCase(raw.charAt(i));
                retChar[i+1] = Character.toUpperCase(raw.charAt(i+1));                
                while (i+offset+1 < raw.length() && raw.charAt(i+offset) == raw.charAt(i+offset+1)) {
                    retChar[i+offset+1] = Character.toUpperCase(raw.charAt(i+offset+1));
                    offset+=1;
                }
                i += offset;
                
            } else {
                retChar[i] = raw.charAt(i);
                retChar[i+1] = raw.charAt(i+1);
            }
        }
        
        System.out.println(new String(retChar));
        
}
}
