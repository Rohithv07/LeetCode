class Solution {
    public int minDeletions(String s) {
        char [] charArray = s.toCharArray();
        int [] count = new int [26];
        for (char ch : charArray)
            count[ch-'a'] += 1;
        // sort the count array
        Arrays.sort(count);
        int result = 0;
        int lastExpectedValue = count[25];
        // traverse from the last
        for (int i=25; i>=0; i--) {
            if (count[i] == 0)
                continue;
            if (count[i] < lastExpectedValue)
                lastExpectedValue = count[i];
            else if (count[i] > lastExpectedValue)
                result += count[i] - lastExpectedValue;
            if (lastExpectedValue > 0)
                lastExpectedValue -= 1; // we check here as it cant be negative
        }
        return result;
    }
}
