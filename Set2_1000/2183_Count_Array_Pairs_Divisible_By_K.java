// if n1 * n2 % k == 0, then gcd(n1, k) * gcd(n2, k) % k == 0.
class Solution {
    public long countPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        GCD gcd = new GCD();
        long pairCount = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int number : nums) {
            int currentGCD = gcd.findGCD(number, k);
            for (int num : map.keySet()) {
                if ((long)currentGCD * num % k == 0) {
                    pairCount += map.get(num);
                }
            }
            map.put(currentGCD, map.getOrDefault(currentGCD, 0) + 1);
        }
        return pairCount;
    }
}

class GCD {
    public int findGCD(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return findGCD(n2, n1 % n2);
    }
}