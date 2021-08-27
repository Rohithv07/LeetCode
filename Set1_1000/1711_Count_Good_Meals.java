// variation of 2sum problem

class Solution {
    public int countPairs(int[] deliciousness) {
        int mod = 1000000007;
        Map<Integer, Integer> map = new HashMap<>();
        long result = 0;
        for (int num : deliciousness) {
            int power = 1;
            // 0 <= deliciousness[i] <= 2^20
            for (int i=0; i<22; i++) {
                if (map.containsKey(power - num)) {
                    result += map.get(power - num);
                    result = result % mod;
                }
                power = power * 2;
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return (int) result;
    }
}
