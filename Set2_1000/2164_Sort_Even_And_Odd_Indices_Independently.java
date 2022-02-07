class Solution {
    public int[] sortEvenOdd(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int []{};
        }
        if (nums.length == 1) {
            return nums;
        }
        int length = nums.length;
        List<Integer> oddIndices = new ArrayList<>();
        List<Integer> evenIndices = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) {
                evenIndices.add(nums[i]);
            }
            else {
                oddIndices.add(nums[i]);
            }
        }
        Collections.sort(evenIndices);
        Collections.sort(oddIndices, Collections.reverseOrder());
        int indexOdd = 0;
        int indexEven = 0;
        for (int i = 0 ; i < length; i++) {
            if (i % 2 == 0) {
                nums[i] = evenIndices.get(indexEven++);
            }
            else {
                nums[i] = oddIndices.get(indexOdd++);
            }
        }
        return nums;
    }
}