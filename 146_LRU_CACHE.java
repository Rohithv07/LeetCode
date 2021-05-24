class ListNode {
    int key;
    int value;
    ListNode next;
    ListNode previous;
    
    ListNode(){};
    ListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    
    private Map<Integer, ListNode> map;
    private ListNode head = new ListNode(-1, -1);
    private ListNode tail = new ListNode(-1, -1);
    private int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head.next = tail;
        tail.previous = head;
    }
    
    public int get(int key) {
       if (map.containsKey(key)) {
            ListNode node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
       }
        else {
            return -1;
        }
        
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        else if (map.size() == capacity) {
            remove(tail.previous);
        }
        insert(new ListNode(key, value));
    }
    
    public void remove(ListNode node) {
        map.remove(node.key);
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }
    
    public void insert(ListNode node) {
        map.put(node.key, node);
        ListNode headNext = head.next;
        head.next = node;
        node.previous = head;
        headNext.previous = node;
        node.next = headNext;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
