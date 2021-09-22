import java.util.HashMap;

class S169 {

    private int maxKey(HashMap<Integer, Integer> maps, int size) {
        for (Integer i : maps.keySet()) {
            if (maps.get(i) > size/2) {
                return i;
            }
        } 
        return 0;
    }

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> maps = new HashMap<>();
        for (int i : nums) {
            if (!maps.containsKey(i)) {
                maps.put(i, 1);
            } else {
                maps.replace(i, 1 + maps.get(i));
            }
        }

        return maxKey(maps, nums.length);
    }
}