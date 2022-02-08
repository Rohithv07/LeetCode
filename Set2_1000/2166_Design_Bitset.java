class Bitset {

    private int size;
    private Set<Integer> oneSet;
    private Set<Integer> zeroSet;
    
    public Bitset(int size) {
        this.size = size;
        this.oneSet = new HashSet<>();
        this.zeroSet = new HashSet<>();
        for (int i = 0; i < size; i++) {
            this.zeroSet.add(i);
        }
    }
    
    public void fix(int idx) {
        oneSet.add(idx);
        zeroSet.remove(idx);
    }
    
    public void unfix(int idx) {
        oneSet.remove(idx);
        zeroSet.add(idx);
    }
    
    public void flip() {
        Set<Integer> inter = zeroSet;
        zeroSet = oneSet;
        oneSet = inter;
    }
    
    public boolean all() {
        return oneSet.size() == size;
    }
    
    public boolean one() {
        return oneSet.size() >= 1;
    }
    
    public int count() {
        return oneSet.size();
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (oneSet.contains(i)) {
                sb.append("1");
            }
            else {
                sb.append("0");
            }
        }
        return sb.toString();
    }
}

/**
 * Your Bitset object will be instantiated and called as such:
 * Bitset obj = new Bitset(size);
 * obj.fix(idx);
 * obj.unfix(idx);
 * obj.flip();
 * boolean param_4 = obj.all();
 * boolean param_5 = obj.one();
 * int param_6 = obj.count();
 * String param_7 = obj.toString();
 */