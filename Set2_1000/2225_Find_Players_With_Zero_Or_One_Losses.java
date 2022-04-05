class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int length = matches.length;
        final int SIZE = (int)(1e5);
        List<List<Integer>> result = new ArrayList<>();
        int [] indegree = new int [SIZE + 1];
        boolean [] played = new boolean [SIZE + 1];
        for (int [] match : matches) {
            int winner = match[0];
            int loser = match[1];
            indegree[loser]++;
            played[loser] = true;
            played[winner] = true;
        }
        List<Integer> winnerOfAll = new ArrayList<>();
        List<Integer> singleGameLoser = new ArrayList<>();
        for (int i = 1; i <= SIZE; i++) {
            if (indegree[i] == 0 && played[i]) {
                winnerOfAll.add(i);
            }
            else if (indegree[i] == 1 && played[i]) {
                singleGameLoser.add(i);
            }
        }
        result.add(new ArrayList<>(winnerOfAll));
        result.add(new ArrayList<>(singleGameLoser));
        return result;
    }
}