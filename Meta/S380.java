package Meta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

class RandomizedSet {
    
    ArrayList<Integer> list = new ArrayList<>();
    // value - index
    HashMap<Integer, Integer> map = new HashMap<>();
    Random r = new Random();

    public RandomizedSet() {
        
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }
    
    // To keep O1 time, cannot simply remove from index;
    public boolean remove(int val) {
        // corner case
        if (!map.containsKey(val)) {
            return false;
        }

        int ival = map.get(val); // index to remove
        
        // swap in list with last item
        int iswap = list.size() -1, swap = list.get(iswap);
        
        list.set(ival, swap);
        list.remove(iswap);
        
        // update map
        map.put(swap, ival);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        int index = r.nextInt(list.size());
        return list.get(index);
    }
}