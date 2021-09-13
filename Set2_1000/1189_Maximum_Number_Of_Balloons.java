class Solution {
    public int maxNumberOfBalloons(String text) {
        if (text == null || text.length() == 0) {
            return 0;
        }
        int length = text.length();
        int count [] = new int [26];
        for (char ch : text.toCharArray()) {
            count[ch - 'a'] += 1; //11 14 13
        }
        int minInstance = count[0];
        minInstance = Math.min(minInstance, count[1]);
        minInstance = Math.min(minInstance, count[11] / 2);
        minInstance = Math.min(minInstance, count[14] / 2);
        minInstance = Math.min(minInstance, count[13]);
        return minInstance;
    }
}