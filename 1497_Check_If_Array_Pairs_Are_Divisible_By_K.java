class Solution {
    public boolean canArrange(int[] arr, int k) {
        int [] freq = new int [k];
        int length = arr.length;
        for (int number : arr) {
            number %= k;
            if (number < 0)
                number += k;
            freq[number] += 1;
        }
        if (freq[0] % 2 != 0)
            return false;
        for (int i=1; i<=k/2; i++) {
            if (freq[i] != freq[k-i])
                return false;
        }
        return true;
    }
}
