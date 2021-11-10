import java.util.PriorityQueue;

public class S215 {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();

        for (int n : nums) {
          heap.add(n);
          if (heap.size() > k)
            heap.poll();
        }

        return heap.poll();
  }
}
