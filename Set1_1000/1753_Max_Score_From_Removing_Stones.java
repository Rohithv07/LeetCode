class Solution {
    public int maximumScore(int a, int b, int c) {
        // there are mainly 2 things happening here
        // Either after taking stones from each pile, we reach a pointer where all a, b, c become zero
        // otherwise we got only 2 piles to end up in 0 and no further continuation
        // if all a, b, c become zero, then the maxscore can be totalSUm / 2
        // otherwise totalSum - max(a, b, c)
        // considering these two condition we need the minimum from the above results.
        return Math.min((a + b + c) / 2, a + b + c - Math.max(a, Math.max(b, c)));
    }
}


class Solution {
    public int maximumScore(int a, int b, int c) {
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        pq.offer(a);
        pq.offer(b);
        pq.offer(c);
        while (pq.size() > 1) {
            int largest = pq.remove();
            int secondLargest = pq.remove();
            sum += 1;
            largest -= 1;
            secondLargest -= 1;
            if (largest > 0) 
                pq.add(largest);
            if (secondLargest > 0)
                pq.add(secondLargest);
        }
        return sum;
    }
}
