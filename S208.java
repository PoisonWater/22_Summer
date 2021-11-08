class Trie { // Tries

    private Trie[] children;
    public boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }
    
    public void insert(String word) {
        if (children[word.charAt(0) - 'a'] == null) {
            children[word.charAt(0) - 'a'] = new Trie();
        }
        if (word.length() != 1) {
            children[word.charAt(0) - 'a'].insert(word.substring(1));
        }
        if (word.length() == 1) {
            children[word.charAt(0) - 'a'].isEnd = true;
        }
        
    }
    
    public boolean search(String word) {
        if (children[word.charAt(0) - 'a'] == null) {
            return false;
        }
        if (word.length() == 1) {
            if (children[word.charAt(0) - 'a'].isEnd) {
                return true;
            }
            return false;
        }
        return children[word.charAt(0) - 'a'].search(word.substring(1));
    }
    
    public boolean startsWith(String prefix) {
        if (children[prefix.charAt(0) - 'a'] == null) {
            return false;
        }
        if (prefix.length() == 1) {
            return true;
        }
        return children[prefix.charAt(0) - 'a'].startsWith(prefix.substring(1));
    }
}


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */


// SOLUTION 2

// class TrieNode {
//     public char val;
//     public boolean isWord; 
//     public TrieNode[] children = new TrieNode[26];
//     public TrieNode() {}
//     TrieNode(char c){
//         TrieNode node = new TrieNode();
//         node.val = c;
//     }
// }


// public class Trie {
    
//     private TrieNode root;
    
//     public Trie() {
//         root = new TrieNode();
//         root.val = ' ';
//     }
    
//     public void insert(String word) {
//         TrieNode tmp = root;
//         for(int i = 0; i < word.length(); i++) {
//             char tmpChar = word.charAt(i);
//             if(tmp.children[tmpChar - 'a'] == null) {
//                 tmp.children[tmpChar - 'a'] = new TrieNode(tmpChar);
//             }
//             tmp = tmp.children[tmpChar - 'a'];
//         }
//         tmp.isWord = true;
        
//     }
    
//     public boolean search(String word) {
//         TrieNode tmp = root;
//         for(int i = 0; i < word.length(); i++) {
//             char tmpChar = word.charAt(i);
//             if(tmp.children[tmpChar - 'a'] == null) {
//                 return false;
//             }
//             tmp = tmp.children[tmpChar - 'a'];
//         }
//         return tmp.isWord;
//     }
    
//     public boolean startsWith(String prefix) {
//         TrieNode tmp = root;
//         for(int i = 0; i< prefix.length(); i++) {
//             char tmpChar = prefix.charAt(i);
//             if(tmp.children[tmpChar - 'a'] == null) {
//                 return false;
//             }
//             tmp = tmp.children[tmpChar - 'a'];
//         }
//         return true;
//     }
// }
