// Solution 1

class MyHashMap {
    
    private int[] hash;
    /** Initialize your data structure here. */
    public MyHashMap() {
        hash = new int[100001];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        hash[key] = value + 1;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return hash[key] - 1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        hash[key] = 0;
    }
}


Points to remember : 
The general implementation of HashMap uses bucket which is basically a chain of linked lists and each node containing <key, value> pair.

So if we have duplicate nodes, that doesn't matter - it will still replicate each key with it's value in linked list node.

When we insert the pair (10, 20) and then (10, 30), there is technically no collision involved. We are just replacing the old value with the new value for a given key 10, since in both cases, 10 is equal to 10 and also the hash code for 10 is always 10.

Collision happens when multiple keys hash to the same bucket. In that case, we need to make sure that we can distinguish between those keys. Chaining collision resolution is one of those techniques which is used for this.

Just for the information. In JDK 8, HashMap has been tweaked so that if keys can be compared for ordering, then any densely-populated bucket is implemented as a tree, so that even if there are lots of entries with the same hash-code, the complexity isO(log n).

// solution 2

class MyHashMap {
    ListNode[] nodes = new ListNode[10000];
    /** Initialize your data structure here. */
    public MyHashMap() {
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = getIndex(key);
        ListNode previous = findElement(index, key);
        if (previous.next == null)
            previous.next = new ListNode(key, value);
        else
            previous.next.value = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = getIndex(key);
        ListNode previous = findElement(index, key);
        return previous.next == null ? -1 : previous.next.value;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = getIndex(key);
        ListNode previous = findElement(index, key);
        if (previous.next != null)
            previous.next = previous.next.next;
    }
    
    public int getIndex(int key) {
        return Integer.hashCode(key) % nodes.length;
    }
    
    public ListNode findElement(int index, int key) {
        if (nodes[index] == null)
            return nodes[index] = new ListNode(-1, -1);
        ListNode previous = nodes[index];
        while (previous.next != null && previous.next.key != key) {
            previous = previous.next;
        }
        return previous;
    }
}

class ListNode {
    int key;
    int value;
    ListNode next;
    ListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}


/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */


// another approach



class ListNode {
    int key;
    int value;
    ListNode next;
    ListNode() {};
    ListNode(int key, int  value) {
        this.value = value;
        this.key = key;
    }
}

class MyHashMap {
    
    private static final int MAX_SIZE = (int) 1e6;
    private ListNode [] bucket;
    /** Initialize your data structure here. */
    public MyHashMap() {
        bucket = new ListNode[MAX_SIZE];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = getIndex(key);
        ListNode previous = getPrevious(index, key);
        if (previous.next == null) {
            previous.next = new ListNode(key, value);
        }
        else {
            previous.next.value = value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = getIndex(key); // hashcode(key) % bucketlength ==== key % bucketlength
        ListNode previous = getPrevious(index, key);
        if (previous.next == null)
            return -1;
        return previous.next.value;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = getIndex(key);
        ListNode previous = getPrevious(index, key);
        if (previous.next == null)
            return;
        previous.next = null;
    }
    
    public int getIndex(int value) {
        return value % bucket.length;
    }
    
    public ListNode getPrevious(int index, int key) {
        if (bucket[index] == null) {
            return bucket[index] = new ListNode(-1, -1);
        }
        ListNode previous = bucket[index];
        while (previous.next != null && previous.next.key != key)
            previous = previous.next;
        return previous;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */


