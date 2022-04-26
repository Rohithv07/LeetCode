class Solution {
    public List<Integer> intersection(int[][] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        int length = nums.length;
        List<Integer> result = new ArrayList<>();
        int [] takeCount = new int [1001];
        for (int [] num : nums) {
            for (int number : num) {
                takeCount[number]++;
            }
        }
        for (int i = 1; i <= 1000; i++) {
            int currentCount = takeCount[i];
            if (currentCount == length) {
                result.add(i);
            }
        }
        return result;
    }
}