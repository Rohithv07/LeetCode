class Solution {
    public int minSteps(String s, String t) {
        int [] count = new int [26];
        int minSteps = 0;
        for (char ch : s.toCharArray()) {
            count[ch - 'a'] += 1;
        }
        for (char ch : t.toCharArray()) {
            count[ch - 'a'] -= 1;
        }
        for (int number : count) {
            if (number != 0) {
                minSteps += Math.abs(number);
            }
        }
        return minSteps;
    }
}