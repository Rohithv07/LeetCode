class NumberContainers {

    private Map<Integer, TreeSet<Integer>> ind;
    private Map<Integer, Integer> vals;
    
    public NumberContainers() {
        ind = new HashMap<>();
        vals = new TreeMap<>();
    }
    
    public void change(int index, int number) {
        if (vals.containsKey(index)) {
            int oldVal = vals.get(index);
            ind.get(oldVal).remove(index);
            if (ind.get(oldVal).isEmpty()) {
                ind.remove(oldVal);
            }
        }
        vals.put(index, number);
        ind.computeIfAbsent(number, x -> new TreeSet<>()).add(index);
    }
    
    public int find(int number) {
        if (ind.containsKey(number)) {
            return ind.get(number).first();
        }
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */