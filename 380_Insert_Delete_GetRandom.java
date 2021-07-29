class RandomizedSet {

    // hashamo key : number and value = its last index
    /** Initialize your data structure here. */
    private Map<Integer, Integer> map;
    private Random random;
    private List<Integer> elements;
    
    public RandomizedSet() {
        map = new HashMap<>();
        random = new Random();
        elements = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            elements.add(val);
            map.put(val, elements.size() - 1);
            return true;
        }
        return false;
    }
    
    // here we find the index of the value to be deleted from the map
    // we then swap this element with the element at the back
    // now the element at back will be at the position where the value to be deleted was before
    // and the value to be deleted will be at the last position
    // now we updated the map 
    // remove the val from the map and list
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        int lastIndex = map.getOrDefault(val, -1);
        if (lastIndex == -1)
            return false;
        Collections.swap(elements, lastIndex, elements.size() - 1);
        int otherSwappedValue = elements.get(lastIndex);
        map.put(otherSwappedValue, lastIndex);
        elements.remove(elements.size() - 1);
        map.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int randomIndex = random.nextInt(elements.size());
        return elements.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */





// less efficient

class RandomizedSet {

    /** Initialize your data structure here. */
    private Set<Integer> set;
    private Random random;
    public RandomizedSet() {
        set = new HashSet<>();
        random = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!set.contains(val)) {
            set.add(val);
            return true;
        }
        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (set.contains(val)) {
            set.remove(val);
            return true;
        }
        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Integer [] randomArray = set.toArray(new Integer[set.size()]);
        return randomArray[random.nextInt(set.size())];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */