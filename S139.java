// TODO!

import java.util.LinkedList;
import java.util.List;
import java.util.HashSet;

class S139 {

    public LinkedList<LinkedList<Character>> ret = new LinkedList<>();
    public String ans = new String();
    public HashSet<String> dict = new HashSet<>();

    
    private boolean dfs(String s, List<String> wordDict, int startPos) {

        if (startPos == s.length()) 
            return true;

        if (dict.contains(ans))
            return false;

        for (int i = startPos; i < s.length(); i++) {

            ans = ans.concat(String.valueOf(s.charAt(i)));
            System.out.println(ans);

            if (wordDict.contains(ans)) {
                String storage = new String(ans);
                ans = new String();
                if (dfs(s, wordDict, i + 1)) {
                    return true;
                } else if (!dict.contains(ans)) {
                    dict.add(new String(ans));
                }
                ans = new String(storage);
            } 

        }

        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, 0);
    }

    public static void main(String[] args) {

        S139 n = new S139();

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("a");
        linkedList.add("aa");
        linkedList.add("aaa");
        linkedList.add("aaaa");
        linkedList.add("aaaaa");
        linkedList.add("aaaaaa");
        linkedList.add("aaaaaaa");

        boolean retur = n.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", linkedList);
        // boolean retur = n.wordBreak("aaaaaaab", linkedList);
        System.out.println(retur);
    }

}