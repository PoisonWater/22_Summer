package Meta;

import java.util.HashMap;

class LRUCache {
    
    class Node{
        Node prev, next;
        int key, value;
        
        public Node() {};
        
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    HashMap<Integer, Node> map = new HashMap<>();
    int capacity, size;
    Node head, tail;
    
    private Node remove(int key) {
        Node toR = map.remove(key);
        toR.prev.next = toR.next;
        toR.prev.next.prev = toR.prev;
        this.size--;
        return toR;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        
        // 有key
        if (map.containsKey(key)) {
            
            Node node = remove(key);
            put(node.key, node.value);
            return node.value;
            
        // 无key
        } else {
            return -1;
        }
        
    }
    
    public void put(int key, int value) {
        
        // key exists
        if (map.containsKey(key)) {
            map.get(key).value = value;
            Node node = remove(key);
            put(node.key, node.value);
            
        // key NOT exists
        } else {
            // add node
            Node node = new Node(key, value);
            node.next = head.next;
            node.prev = head;
            head.next = node;
            node.next.prev = node;
            size++;
            map.put(key, node);
            
            // if max capacity
            if (size > capacity) {
                remove(tail.prev.key);
            }
            
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

// 分开remove更快！
class LRUCache1 {
  
    int capacity;
    HashMap<Integer,Node> hashMap;
    Node head;
    Node tail;
    
    public LRUCache1(int capacity) {
        this.capacity = capacity;
        hashMap = new HashMap<>(capacity);
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
    
       public int get(int key) {
        Node node = hashMap.get(key);
        int result = -1;
        if(node!=null){
            result = node.value;
            remove(node);
            add(node);
        }
        
        return result;
    }
    
    public void put(int key, int value) {
        Node node = hashMap.get(key);
        if(node!=null){
            node.value = value;
            remove(node);
            add(node);
        }else{
            if(hashMap.size() == capacity){
                hashMap.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node newNode = new Node(key,value);
            hashMap.put(key,newNode);
            add(newNode);
        }
    }
    
    
    class Node{
        int key; 
        int value;
        Node next;
        Node prev;
        
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    private void add(Node node){
        Node headNext = head.next;
        head.next = node;
        node.next = headNext;
        headNext.prev = node;
        node.prev = head;
    }
    
    private void remove(Node node){
        Node nextNode = node.next;
        Node prevNode = node.prev;
        nextNode.prev = prevNode;
        prevNode.next = nextNode;
    }
}
