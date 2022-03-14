class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        // lcm = (a * b) / gcd
        LinkedList<Integer> result = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        if (nums.length == 1) {
            result.add(nums[0]);
            return result;
        }
        for (int number : nums) {
            while (true) {
                int lastElement = result.isEmpty() ? 1 : result.getLast(); // triggers mainly on the very first element
                int gcd = findGCD(lastElement, number);
                if (gcd == 1 ) {
                    break; // we should not want this
                }
                number = number * (result.removeLast() / gcd); // done division first to avoid overflow
            }
            result.add(number);
        }
        return result;
    }
    
    public int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }
}