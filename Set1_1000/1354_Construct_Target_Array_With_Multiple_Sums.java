class Solution {
    public boolean isPossible(int[] target) {
        int length = target.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        long totalSum = 0;
        for (int number : target) {
            totalSum += number;
            pq.add(number);
        }
        while (true) {
            int current = pq.poll();
            totalSum -= current;
            if (totalSum == 1 || current == 1)
                return true;
            if (current < totalSum || totalSum <= 0 || current % totalSum == 0)
                return false;
            current %= totalSum;
            totalSum += current;
            pq.add(current);
        }
    }
}
