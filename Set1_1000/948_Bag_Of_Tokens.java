class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        if (tokens.length == 1 && tokens[0] > P)
            return 0;
        Arrays.sort(tokens);
        int score = 0;
        int maxScore = 0;
        int left = 0;
        int right = tokens.length - 1;
        while (left <= right) {
            if (P >= tokens[left]) {
                score ++;
                P -= tokens[left++];
                maxScore = Math.max(maxScore, score);
            }
            else if (score > 0) {
                score --;
                P += tokens[right--];
            }
            else
                return maxScore;
        }
        return maxScore;
    }
}
