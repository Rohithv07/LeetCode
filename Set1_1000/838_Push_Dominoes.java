class Solution {
    public String pushDominoes(String dominoes) {
        if (dominoes == null || dominoes.length() == 0)
            return "";
        char [] result = dominoes.toCharArray();
        int lLastSeen = -1;
        int rLastSeen = -1;
        int length = dominoes.length();
        for (int i=0; i<=length; i++) {
            if (i == result.length || result[i] == 'R') {
                if (rLastSeen > lLastSeen) {
                    // R...R - turn all R
                    while (rLastSeen < i) {
                        result[rLastSeen++] = 'R';
                    }
                }
                rLastSeen = i;
            }
            else if (result[i] == 'L') {
                if (lLastSeen > rLastSeen || (rLastSeen == -1 && lLastSeen == -1)) {
                    // L....L, turn all L
                    while (++lLastSeen < i) {
                        result[lLastSeen] = 'L';
                    }
                }
                else {
                    // R...L
                    lLastSeen = i;
                    int low = rLastSeen + 1;
                    int high = lLastSeen - 1;
                    while (low < high) {
                        // . in middle is unchanged
                        result[low++] = 'R';
                        result[high--] = 'L';
                    }
                }
            }
        }
        return new String(result);
    }
}