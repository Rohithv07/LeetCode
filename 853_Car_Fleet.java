class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        // sort based on the positions
        int length = position.length;
        for (int i=0; i<length; i++) {
            map.put(position[i], speed[i]);
        }
        double slowest = 0.0;
        int fleetCount = 0;
        for (int distance : map.keySet()) {
            // finding the time using formula distance / speed
            double time = (double)(target - distance) / map.get(distance);
            if (time > slowest) {
                slowest = time;
                fleetCount += 1;
            }
        }
        return fleetCount;
    }
}
