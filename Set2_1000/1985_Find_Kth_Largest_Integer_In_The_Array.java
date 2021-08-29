class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        if (nums == null || nums.length == 0)
            return "";
        int length = nums.length;
        PriorityQueue<String> minHeap = new PriorityQueue<>((s1, s2) -> {
            if (s1.length() == s2.length()) 
                return s1.compareTo(s2);
            else
                return Integer.compare(s1.length(), s2.length());
        });
        for (String num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }
}