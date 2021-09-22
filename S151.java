import java.util.LinkedList;

class S151 {
    public String reverseWords(String s) {
        
        int startPtr = 0;
        boolean inSpace = false;
        s = s.concat(" ");
        LinkedList<String> ll = new LinkedList<>();

        while (s.charAt(startPtr) == ' ') {
            startPtr++;
        }

        for (int i = startPtr ; i < s.length(); i++) {

            if (inSpace) {
                startPtr++;
                if (s.charAt(i) != ' ') {
                    inSpace = false;
                }

            } else {
                if (s.charAt(i) == ' ') {
                    ll.addFirst(s.substring(startPtr, i));
                    inSpace = true;
                    startPtr = i;
                }
            }

        }

        String ret = String.join(" ", ll);
        return ret;
    }
}

// class Solution {
//     public String reverseWords(String s) {
//         // 除去开头和末尾的空白字符
//         s = s.trim();
//         // 正则匹配连续的空白字符作为分隔符分割
//         List<String> wordList = Arrays.asList(s.split("\\s+"));
//         Collections.reverse(wordList);
//         return String.join(" ", wordList);
//     }
// }