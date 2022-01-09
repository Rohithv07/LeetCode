// same concept as that of hashmap

class MyHashSet {

    private ListNode [] bucket;
    
    public MyHashSet() {
        bucket = new ListNode[1000000];
    }
    
    public void add(int key) {
        int indexToAdd = findIndex(key);
        ListNode previous = findPrevious(indexToAdd, key);
        if (previous.next == null) {
            previous.next = new ListNode(key);
        }
        else {
            previous.next.key = key;
        }
    }
    
    public void remove(int key) {
        int indexToRemove = findIndex(key);
        ListNode previous = findPrevious(indexToRemove, key);
        if (previous.next != null) {
            previous.next = previous.next.next;
        }
    }
    
    public boolean contains(int key) {
        int indexToContains = findIndex(key);
        ListNode previous = findPrevious(indexToContains, key);
        
        if (previous.next == null) {
            return false;
        }
        return true;
    }
    
    public int findIndex(int key) {
        return Integer.hashCode(key) % bucket.length; // hashcode & n - 1
    }
    
    public ListNode findPrevious(int index, int key) {
        if (bucket[index] == null) {
            return bucket[index] = new ListNode(-1);
        }
        ListNode previous = bucket[index];
        while (previous.next != null && previous.next.key != key) {
            previous = previous.next;
        }
        return previous;
    }
}

class ListNode {
    int key;
    ListNode next;
    public ListNode(int key) {
        this.key = key;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */





// https://www.youtube.com/watch?v=NrMaQL_4Npo&t=1107s

class MyHashSet {
    
    private final int MAX_SIZE = (int) (1e6);
    private final int ARRAY_SIZE = 100;
    private List<List<Integer>> parentList;
    /** Initialize your data structure here. */
    public MyHashSet() {
        parentList = new ArrayList<>(MAX_SIZE);
        for (int i=0; i<ARRAY_SIZE; i++) {
            parentList.add(null);
        }
    }
    
    public void add(int key) {
        int bucket = key % ARRAY_SIZE;
        List<Integer> childList = parentList.get(bucket);
        if (childList == null) {
            List<Integer> link = new LinkedList<>();
            link.add(key);
            parentList.set(bucket, link);
        }
        else {
            if (!childList.contains(key)) {
                childList.add(key);
            }
        }
    }
    
    public void remove(int key) {
        int bucket = key % ARRAY_SIZE;
        List<Integer> childList = parentList.get(bucket);
        if (childList != null) {
            childList.remove(Integer.valueOf(key));
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = key % ARRAY_SIZE;
        List<Integer> childList = parentList.get(bucket);
        return childList != null && childList.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
