// import java.util.HashMap;

class S242 {

    // 1. Import HashMap

    // public boolean isAnagram(String s, String t) {
    //     HashMap<Character, Integer> map = new HashMap<>();
        
    //     for (char i : s.toCharArray()) {
    //         if (!map.containsKey(i)) {
    //             map.put(i, 1);
    //         } else {
    //             map.put(i, map.get(i) + 1);
    //         }
    //     }

    //     for (char i : t.toCharArray()) {
    //         if (!map.containsKey(i)) {
    //             return false;
    //         } else {
    //             map.put(i, map.get(i) - 1);
    //         }
    //     }

    //     for (Integer i : map.values()) {
    //         if (i != 0) {
    //             return false;
    //         }
    //     }

    //     return true;

    // }

    
    // 2. 实现简易HashMap

    public boolean isAnagram(String s, String t) {

        int[] map = new int[26];

        for (char i : s.toCharArray()) {
            map[i - 'a']++;
        }

        for (char i : t.toCharArray()) {
            map[i - 'a']--;
        }

        for (int i : map) {
            if (i != 0) {
                return false;
            }
        }

        return true;

    }

}
