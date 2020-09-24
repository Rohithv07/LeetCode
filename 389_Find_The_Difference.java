/*
s = a b c d
t = a b c d e..


So (a-a) + (b-b) + (c-c) + (d-d) + e = e.. So trying out with the ascii character and returing the remaining as character will give the answer.

*/

class Solution {
    public char findTheDifference(String s, String t) {
        int index = -1;
        int sum = 0;
        while (++index < s.length()) {
            sum += t.charAt(index) - s.charAt(index);
        }
        sum += t.charAt(index);
        return (char) sum;
    }
}
