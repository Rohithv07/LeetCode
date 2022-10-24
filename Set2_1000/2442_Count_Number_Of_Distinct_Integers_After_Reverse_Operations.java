class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> distinct = new HashSet<>();
        for (int num : nums) {
            distinct.add(num);
            int reversed = reverse(num);
            distinct.add(reversed);
        }
        return distinct.size();
    }
    
    
    private int reverse(int num) {
        int reversed = 0;
        while (num > 0) {
            int rem = num % 10;
            reversed = reversed * 10 + rem;
            num /= 10;
        }
        return reversed;
    }
}