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
