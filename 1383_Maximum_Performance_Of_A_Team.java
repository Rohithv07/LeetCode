class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int mod = (int) 1e9 + 7;
        int [][] workers = new int [n][2];
        for (int i=0; i<n; i++) {
            workers[i] = new int [] {efficiency[i], speed[i]};
        }
        Arrays.sort(workers, (a, b) -> b[0] - a[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        long adder = 0;
        long max = Long.MIN_VALUE;
        for (int [] worker : workers) {
            if (pq.size() == k) {
                adder -= pq.poll();
            }
            pq.add(worker[1]);
            adder += worker[1];
            max = Math.max(max, adder * worker[0]);
        }
        return (int) (max % (long)mod);
    }
}



