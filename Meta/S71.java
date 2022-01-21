package Meta;

import java.util.Stack;

class S71 {

    // R2，TODO：注意corner case
    public String simplifyPathR2(String path) {
        
        // Eg. "/home/lib/..//"
        
        // Split Path
        String[] splitted = path.split("/"); // "home; lib; ..;"
        
        // Stack for storing results
        Stack<String> stack = new Stack<>();
        
        // loop
        for (String s : splitted) {
            
            // 1. empty || curr dir?
            if (s.length() == 0 || s.equals(".")) { continue; }
            
            // 2. prev dir - 注意corner cases！- empty stack
            if (s.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
                
            // 3. normal dir name
            } else {
                stack.push(s);
            }
            
        }
        
        // Construct result;
        if (stack.isEmpty()) { return "/"; }
        
        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append("/");
            sb.append(s);
        }
        
        return sb.toString();
        
    }

    // Revisit
    public String simplifyPath0(String path) {
        // 1. split - "/" "//" - handle empty splitted string
        // 2. "." - nothing happens
        // 3. ".." - stack pop when not empty
        
        String[] splitted = path.split("/");
        Stack<String> stack = new Stack<>();
        
        // Deconstructing part
        for (String s : splitted) {
            
            if (s.equals(".") || s.isBlank()) {
                continue;
            }
            
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }
            
            stack.push(s);
            
        }
        
        // Reconstruct
        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append("/");
            sb.append(s);
        }
        
        if (sb.length() == 0) {
            return "/";
        }
        
        return sb.toString();
        
    }

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
