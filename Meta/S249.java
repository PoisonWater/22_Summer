package Meta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class S249 {

    // Revisited
    // use String id as key of the hashmap
    // key: 1&1& (abc & bcd)
    private String genId(String str) {
        char[] chs = str.toCharArray();
        
        char prev = chs[0];
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < chs.length; i++) {
            int gap = chs[i] - prev;
            if (gap < 0) { gap += 26; }
            sb.append(gap);
            sb.append('&');
            prev = chs[i];
        }
        return sb.toString();
    }
    
    public List<List<String>> groupStrings(String[] strings) {
        
        List<List<String>> ret = new ArrayList<>();
        
        // Corner Case
        if (strings.length == 1) { 
            List<String> tmp = new ArrayList<>();
            tmp.add(strings[0]);
            ret.add(tmp);
            return ret;
        }
        
        HashMap<String, List<String>> map = new HashMap<>();
        
        for (String s : strings) {
            String id = genId(s); // id is the feature key of the string; same key are in the same type
            if (!map.containsKey(id)) {
                ArrayList<String> lsPtr = new ArrayList<>();
                map.put(id, lsPtr);
                ret.add(lsPtr);
            }
            map.get(id).add(s);
        }
        
        return ret;
        
    }
}
