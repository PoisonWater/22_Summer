import java.util.HashSet;

class S136 {
    public int singleNumber(int[] nums) {
        HashSet<Integer> trace = new HashSet<>();
        for (Integer i : nums) {
            if (!trace.contains(i)) {
                trace.add(i);
            } else {
                trace.remove(i);
            }
        }

        return trace.iterator().next();
    }
}