class UndergroundSystem {
    
    Map<Integer, StationEntry> map;
    Map<String, Integer> count;
    Map<String, Double> diff;
    public UndergroundSystem() {
        map = new HashMap<>();
        count = new HashMap<>();
        diff = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        StationEntry stationEntry = new StationEntry(stationName, t);
        map.put(id, stationEntry);
    }
    
    public void checkOut(int id, String stationName, int t) {
        StationEntry stationEntry = map.get(id);
        double differ = t - stationEntry.time;
        String key = stationEntry.stationName + "-" + stationName;
        diff.put(key, diff.getOrDefault(key, 0.0) + differ);
        count.put(key, count.getOrDefault(key, 0) + 1);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "-" + endStation;
        if (diff.containsKey(key)) {
            return diff.get(key) / count.get(key);
        }
        return 0.0;
    }
}

class StationEntry {
    String stationName;
    int time;
    StationEntry(String stationName, int time) {
        this.stationName = stationName;
        this.time = time;
    }
}
/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
