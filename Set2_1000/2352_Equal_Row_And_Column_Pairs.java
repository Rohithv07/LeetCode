Given a 0-indexed n x n integer matrix grid, return the number of pairs (Ri, Cj) such that row Ri and column Cj are equal.

A row and column pair is considered equal if they contain the same elements in the same order (i.e. an equal array).

 

Example 1:


Input: grid = [[3,2,1],[1,7,6],[2,7,7]]
Output: 1
Explanation: There is 1 equal row and column pair:
- (Row 2, Column 1): [2,7,7]
Example 2:


Input: grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
Output: 3
Explanation: There are 3 equal row and column pairs:
- (Row 0, Column 0): [3,1,2,2]
- (Row 2, Column 2): [2,4,2,2]
- (Row 3, Column 2): [2,4,2,2]
 

Constraints:

n == grid.length == grid[i].length
1 <= n <= 200
1 <= grid[i][j] <= 105


class Solution {
    public int equalPairs(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;
        Map<String, Integer> track = new HashMap<>(); 
        for (int i = 0; i < row; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append("#");
            for (int j = 0; j < col; j++) {
                int current = grid[i][j];
                sb.append(current);
                sb.append("#");
            }
            String check = sb.toString();
            track.put(check, track.getOrDefault(check, 0) + 1);
        }
        for (int i = 0; i < col; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append("#");
            for (int j = 0; j < row; j++) {
                int current = grid[j][i];
                sb.append(current);
                sb.append("#");
            }
            String check = sb.toString();
            if (track.containsKey(check)) {
                count += track.get(check);
            }
        }
        return count;
    }
}