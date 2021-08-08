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


// same approach different eay

class Solution {
    public boolean canArrange(int[] arr, int k) {
        if (arr == null || arr.length == 0 || arr.length % 2 == 1)
            return false;
        int length = arr.length;
        for (int i=0; i<length; i++) {
            arr[i] = (arr[i] % k + k) % k;
        }
        int [] hash = new int [k];
        for (int i=0; i<length; i++) {
            hash[arr[i]] += 1;
        }
        if (hash[0] % 2 == 1)
            return false;
        for (int i=1; i<k; i++) {
            if (hash[i] != hash[k - i])
                return false;
        }
        return true;
    }
}
