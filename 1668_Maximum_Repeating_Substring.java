class Solution {
    public int maxRepeating(String sequence, String word) {
        int answer = 1;
        while (sequence.indexOf(word.repeat(answer)) >= 0)
            answer ++;
        return answer - 1;
    }
}
