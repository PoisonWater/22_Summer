package Meta;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class S139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        Queue<Integer> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        boolean[] visited = new boolean[s.length() + 1];
        
        // Constructing set
        for (String word : wordDict) {
            set.add(word);
        }
        
        // BFS
        queue.offer(0);
        visited[0] = true;
        
        while (!queue.isEmpty()) {
            int start = queue.poll();
            
            for (int end = start+1; end <= s.length(); end++) {
                if (!visited[end] && set.contains(s.substring(start, end))) {
                    queue.offer(end);
                    visited[end] = true;
                    if (end == s.length()) { return true; }
                }
            }
            
        }
        
        return false;
        
    }
}
