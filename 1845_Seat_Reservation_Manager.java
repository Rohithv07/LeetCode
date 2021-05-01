class SeatManager {

    private TreeSet<Integer> map;
    int index = 0;
    
    public SeatManager(int n) {
        map = new TreeSet<>();
        for (int i=0; i<n; i++) {
            map.add(i + 1);
        }
    }
    
    public int reserve() {
        int value = map.pollFirst();
        return value;
    }
    
    public void unreserve(int key) {
        map.add(key);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
