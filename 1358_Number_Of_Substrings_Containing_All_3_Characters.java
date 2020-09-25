// Sliding window approach

class Solution {
    public int numberOfSubstrings(String s) {
        int [] count = new int[]{0, 0, 0};
        int i = 0;
        int result = 0;
        for (int j=0; j<s.length(); j++) {
            count[s.charAt(j) - 'a'] += 1;
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                count[s.charAt(i++) - 'a'] -= 1; 
            }
            result += i;  //[i-1 .. j] represents minimum length sub-array ending at j which has all three characters.
                      // this subarray could be extended left till idx == 0 without compromising the count constraint
                      // which is a total of length([0..i-1]) = i subarrays ending at j
        }
        return result;
    }
}
/* 
Idea here is that we store the last occurance of each a, b, c using 3 pointers say l1, l2, l3 which gets updates based on the occurance of a, b, c and its index is stored. Now we take the minimum from l1, l2, l3 and add result + minimum + 1.

If the smallest sub-string is from min-index to curr-index, then for every sub-string starting from index 0, 1, 2, 3, ......min-index and ending at curr-index is valid, (So how many are these...... So there are min-index + 1 sub-strings)
Add this min-index + 1 to the count.

*/
class Solution {
    public int numberOfSubstrings(String s) {
        int l1 = -1;
        int l2 = -1;
        int l3 = -1;
        int result = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == 'a')
                l1 = i;
            else if (s.charAt(i) == 'b')
                l2 = i;
            else
                l3 = i;
            int minimum = Math.min(l1, Math.min(l2, l3));
            result += minimum + 1;
        }
        return result;
    }
}
