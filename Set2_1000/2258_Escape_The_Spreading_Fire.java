class Solution {
    private int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    public int maximumMinutes(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        List<int[]> fires = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fires.add(new int[]{i, j});
                }
            }
        }

        int l = -1, r = m * n;
        while (l < r) {
            int mid = l + (r - l) / 2 + 1;
            if (reachable(grid, mid, fires)) l = mid;
            else r = mid - 1;
        }
        return l == m * n ? (int) 1e9 : l;
    }

    boolean reachable(int[][] grid, int move, List<int[]> fires) {
        int m = grid.length, n = grid[0].length;
        int[][] copy = clone(grid);

        Queue<int[]> fire = new LinkedList<>();
        fire.addAll(fires);
        while (!fire.isEmpty() && move-- > 0) {
            if (spread(fire, copy)) return false;
        }

        Queue<int[]> person = new LinkedList<>();
        person.add(new int[]{0, 0});
        while (!person.isEmpty()) {
            boolean onFire = spread(fire, copy);
            if (spread(person, copy)) return true;
            if (onFire) return false;
        }
        return false;
    }

    // return true if it spreads to safehouse
    boolean spread(Queue<int[]> queue, int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int size = queue.size();

        while (size-- > 0) {
            int[] cell = queue.remove();
            for (int[] d : directions) {
                int x = cell[0] + d[0] , y = cell[1] + d[1];
                if (x == m - 1 && y == n - 1) return true;
                if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 0) {
                    grid[x][y] = -1;
                    queue.add(new int[]{x, y});
                }
            }
        }
        return false;
    }

    int[][] clone(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] copy = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = grid[i][j];
            }
        }
        return copy;
    }
}