// so lets start by taking the frequency of each charcters of both the strings.
// now in case of s, we increment the freq of respective characters.
// in case of t, we decrement the freq of respective character.
// so now inside the freq array, we will be having the difference of the frequency.
// so we can make a sum of this difference and divide by 2 to get the minimum steps.
// we need to divide by 2 because we consider both the strings and we only need to make change in 1 string, so the half of the answer is enough.

class Solution {
    public int minSteps(String s, String t) {
        // start with base case if both strings are equal
        if (s.equals(t))
            return 0;
        int count = 0;
        // lets take the frequency array
        int [] freq = new int[26];
        for (char ch: s.toCharArray())
            freq[ch - 'a'] += 1;
        // now go through the t string and minus from the freq array
        for (char ch: t.toCharArray())
            freq[ch-'a'] -= 1;
        // next take the sum of the difference and return its half
        for (int i=0; i<26; i++) 
            count += Math.abs(freq[i]);
        return count / 2;
    }
}
