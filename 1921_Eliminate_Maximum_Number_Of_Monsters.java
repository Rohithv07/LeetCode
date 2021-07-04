class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int monsters = 0;
        for (int number : dist) {
            if (number == 0)
                return monsters;
        }
        // sort by time
        for (int i=0; i<dist.length; i++) {
            dist[i] = (int) Math.ceil((double) dist[i] / speed[i]);
        }
        Arrays.sort(dist);
        for (monsters = 0; monsters < dist.length && dist[monsters] > monsters; monsters++);
        return monsters;
    }
}
