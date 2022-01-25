package Meta;

// Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

// Example 1:
// Input: head = [1,1,2]
// Output: [1,2]

// Example 2:
// Input: head = [1,1,2,3,3]
// Output: [1,2,3]

// [1,2,3]
//      |

// class Node {
//   Node next;
//   int val;
// }

//        |
// [1,2,3]

// class Solution {
    
//   public Node deleteDuplicate(Node head) { // [1,2,3,3]
    
//     // Corner Cases
//     if (head == null) {
//       return null;
//     }
    
//     Node ptr = head;
    
    
//     //        |
//     // [1,2,3]
    
//     // Loop through
//     while (ptr != null) {
      
//       while (ptr.next != null && ptr.next.val == ptr.val) {
//         ptr.next = ptr.next.next;
//       }
      
//       ptr = ptr.next;
      
//     }
    
//     return head;
     
//   }
  
// }
  

// start  | end  | memory usage | program 
// 0      | 30   | 70           | A
// 20     | 40   | 100          | B
// 30     | 50   | 50           | C


// start  | end  | memory usage | program 
// 0      | 30   | 70           | A
// 35     | 40   | 100          | B
// 30     | 40   | 50           | C



// PQ
// [30, 40, 50] [35,40,100]

// int currMem = 50, maxMem;


// "0|30|70|A"
// Input : List<String>
// Output maxMem


class Solution {
  
    public int getMem(List<String> logs) {
      
      // Parse info
      List<int[]> info = new ArrayList<>();
      
      for(String log : logs) {
        
        String[] splitted = log.split("|");
        
        info.add(new int[]{Integer.parseInt(splitted[0]), Integer.parseInt(splitted[1]), Integer.parseInt(splitted[2])});
        
      }
                 
      // Priority queue
      
      int currMem = 0, maxMem = 0;
      PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> ((int[])a)[1] - ((int[])b)[1]);
      
      for (int[] in : info) {
        
        while (!pq.isEmpty() && pq.peek()[1] < in[0]) {
          int[] popped = pq.poll();
          currMem -= popped[2];
        }
        
        pq.offer(in);
        
        currMem += in[2];
        maxMem = Math.max(maxMem, currMem);
      
      }
      
      return maxMem;
      
  }
  
  
  
  
  
  
  
  
  
}  