class Solution {
    public int minimumDeviation(int[] nums) {
        // 1. We can use a Treeset here as we can get the values in sorted order
        TreeSet<Integer> set = new TreeSet<>();
        // 2. If the values inside array is even, just simply add it into set else add value*2 into the set(operation given)
        for (int val : nums) {
            if (val % 2 == 0)
                set.add(val);
            else
                set.add(val * 2);
        }
        int answer = Integer.MAX_VALUE;
        while (true) {
            // 3. Use the last() method to get the last value which is the largest and take the diff wrt to that last value
            int lastValue = set.last();
            // 4. Update the answer
            answer = Math.min(answer, lastValue - set.first());
            // 5. If we encounter an even number at the lastValue, we just remove and add evenNumber / 2 to it.(operation given)
            if (lastValue % 2 == 0) {
                set.remove(lastValue);
                set.add(lastValue / 2); // we do this until the number becomes odd.
            }
            else
                break;
        }
        return answer;
    }
}

// nlognlogm -> m = largest number
