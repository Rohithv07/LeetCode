// similar to longest increasing subsequence problem
class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int result = 0;
        // storing both the score and age into single n * 2 array in order age, score
        int [][] team = new int [scores.length][2];
        for (int i=0; i<scores.length; i++) {
            team[i][0] = ages[i];
            team[i][1] = scores[i];
        }
        // sorting by age and then by score
        Arrays.sort(team, (a, b) -> (a[0] != b[0]) ? a[0] - b[0] : a[1] - b[1]);
        
        // initialise a dp array
        int [] dp = new int [scores.length];
        dp[0] = team[0][1];
        for (int i=1; i<scores.length; i++) {
            int max = team[i][1]; //At least it could start a new sequence by itself without extend
			// for each current index, go visit all previous index to grow the sequences
            for (int j=0; j<i; j++) {
                if (team[i][1] >= team[j][1]) {
                    max = Math.max(max, team[i][1] + dp[j]);
                }
            }
            dp[i] = max;
        }
        for (int number: dp)
            result = Math.max(result, number);
        return result;
    }
}
