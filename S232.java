import java.util.Stack;

public class S232 {

    class MyQueue {

        Stack<Integer> stack1;
        Stack<Integer> stack2;

        /** Initialize your data structure here. */
        public MyQueue() {
            stack1 = new Stack<>(); // 负责进栈
            stack2 = new Stack<>(); // 负责出栈
        }
        
        /** Push element x to the back of queue. */
        public void push(int x) {
            stack1.push(x);
        }
        
        /** Removes the element from in front of queue and returns that element. */
        public int pop() {    
            dumpStack1();
            return stack2.pop();
        }
        
        /** Get the front element. */
        public int peek() {
            dumpStack1();
            return stack2.peek();
        }
        
        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }

        // 如果stack2为空，那么将stack1中的元素全部放到stack2中
        private void dumpStack1(){
            if (stack2.isEmpty()){
                while (!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

}
