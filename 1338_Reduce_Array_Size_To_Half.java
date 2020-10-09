// we are given an array and we can remove all the occurance of a set of integer and make the array length half.
// so I think we need to find the total count of each of the numbers.
// then we look for those numbers whose sum of occurance will >= to the half of the total length and we cna consider it as a possible answer.
// sometime there can only be 1 number repeated many times.

class Solution {
    public int minSetSize(int[] arr) {
        // here we can make use of map to track the occurances
        Map<Integer, Integer> map = new HashMap<>();
        int length = arr.length;
        int count = 0;
        // populate the map with count
        for (int num: arr)
            map.put(num, map.getOrDefault(num, 0) + 1);
        // now we use a priority queue inorder to get the maximum and minimum values from the map and add them into the queue
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // basically sorting based on large and small
        for (Integer values: map.values())
            pq.offer(values);
        // now we pop out the element from the queue and added with a varible say sum.
        // we will also be updating our count which is the final result.
        // so when our sum >= middle, then we just return the count.
        int sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
            count += 1;
            if (sum >= (length) / 2)
                return count;
        }
        return 0;
    }
}
