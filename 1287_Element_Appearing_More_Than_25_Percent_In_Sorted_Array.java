
class Solution {
    public int findSpecialInteger(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int twentyFivePercent = (arr.length * 25) / 100;
        for (int number: arr)
            map.put(number, map.getOrDefault(number, 0)+1);
        for (int keys: map.keySet()) {
            int occurance = map.get(keys);
            if (occurance > twentyFivePercent)
                return keys;
        }
        return -1;
    }
}


class Solution {
    public int findSpecialInteger(int [] arr) {
        int n = arr.length;
        int twentyFivePercent = n / 4;
        for (int i=0; i<n-twentyFivePercent; i++) {
            if (arr[i] == arr[i+twentyFivePercent])
                return arr[i];
        }
        return -1;
    }
}
