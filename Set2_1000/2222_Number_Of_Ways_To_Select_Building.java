class Solution {
    public long numberOfWays(String s) {
        long countOfOne = 0;
        long countOfZero = 0;
        long answer = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                countOfOne++;
            }
            else {
                countOfZero++;
            }
        }
        long fromCurrent0 = 0; // for 101
        long fromCurrent1 = 0; // for 010
        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                answer += (fromCurrent1 * countOfZero);
                countOfOne--;
                fromCurrent0++;
            }
            else {
                answer += (fromCurrent0 * countOfOne);
                countOfZero--;
                fromCurrent1++;
            }
        }
        return answer;
    }
}