package Meta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class S1424 {

    public int[] findDiagonalOrder0(List<List<Integer>> nums) {
        
        // i+j to List of values
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        // add to hashmap from bottom which is the first in
        for (int i = nums.size() - 1; i >= 0; i--) {
            int rowSize = nums.get(i).size();
            for (int j = 0; j < rowSize; j++) {
                map.putIfAbsent(i+j, new LinkedList<>());
                map.get(i+j).add(nums.get(i).get(j));
            }
        }
        
        int id = 0;
        List<Integer> ret = new ArrayList<>();
        
        while (map.containsKey(id)) {
            List<Integer> curr = map.get(id);
            ret.addAll(curr);
            id++;
        }
        
        int[] res = new int[ret.size()];
        for (int i = 0; i < ret.size(); i++) {
            res[i] = ret.get(i);
        }
        
        return res;
        
    }
    
    // TLE 用 hashMap
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        
        List<Integer> ret = new ArrayList<>();
        
        int m = 0, n = 0, maxLen = 0;
        
        while (m < nums.size()) {
            
            maxLen = Math.max(maxLen, nums.get(m).size());
            while (m >= 0) {
                // found existance
                if (n < nums.get(m).size()) {
                    ret.add(nums.get(m).get(n));
                }
                n++;
                m--;
            }
            
            // m = -1 n = next_m
            m = n;
            n = 0;
            
        }
        
        for (int i = 1; i < maxLen; i++) {
            m = nums.size() - 1;
            n = i;
            
            while (m >= 0 && n < maxLen) {
                if (n < nums.get(m).size()) {
                    ret.add(nums.get(m).get(n));
                }
                n++;
                m--;
            }
        }
        
        int[] array = new int[ret.size()];
        for (int i = 0; i < ret.size(); i++) {
            array[i] = ret.get(i);
        }
        return array;
    }
}
