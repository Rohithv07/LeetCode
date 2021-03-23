class Solution {
    public int threeSumMulti(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int mod = (int) 1e9 + 7;
        for (int i=0; i<arr.length; i++) {
            count = (count + map.getOrDefault(target - arr[i], 0)) % mod;
            for (int j=0; j<i; j++) {
                int value = arr[i] + arr[j];
                map.put(value, map.getOrDefault(value, 0) + 1);
            }
        }
        return count % mod;
    }
}
