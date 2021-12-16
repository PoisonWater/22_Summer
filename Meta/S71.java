package Meta;

import java.util.Stack;

class S71 {

    public String simplifyPath(String path) {
        
        Stack<String> parser = new Stack<>();
        String[] splitted = path.split("/");
        
        for (String s : splitted) {
            if (s.isBlank() || s.equals(".")) {
                continue;
            }
            if (s.equals("..")) {
                if (parser.isEmpty()) {
                    continue;
                }
                parser.pop();
            } else {
                parser.push(s);
            }
        }
        
        if (parser.size() == 0) { return "/"; }

        StringBuilder sr = new StringBuilder();
        
        for (String s : parser) {
            sr.append("/");
            sr.append(s);
        }
        
        return sr.toString();
        
    }
    
}
