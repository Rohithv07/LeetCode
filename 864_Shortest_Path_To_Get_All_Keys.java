 class Solution {
     
     // my approach getting wrong answer
     
//     public int shortestPathAllKeys(String[] grid) {
//         int row = grid.length;
//         int col = grid[0].length();
//         int si = -1;
//         int sj = -1;
//         int key = 0;
//         for (int i=0; i<row; i++) {
//             for (int j=0; j<col; j++) {
//                 char ch = grid[i].charAt(j);
//                 if (ch == '@') {
//                     si = i;
//                     sj = j;
//                 }
//                 else if (isKey(ch)) {
//                     key ++;
//                 }
//             }
//         }
//         int [][] directions = new int [][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
//         Node node = new Node(si, sj, 0);
//         Queue<Node> queue = new LinkedList<>();
//         queue.offer(node);
//         Set<String> visited = new HashSet<>();
//         visited.add(si + " " + sj + " " + 0);
//         int level = 0;
//         while (!queue.isEmpty()) {
//             int size = queue.size();
//             for (int i=0; i<size; i++) {
//                 Node current = queue.poll();
//                 if (current.key == (1 << key) - 1) // equi (1 * pow(2, key)) - 1
//                     return level;
//                 for (int [] dir : directions) {
//                     int x = current.i + dir[0];
//                     int y = current.j + dir[1];
//                     int k = current.key;
//                     if (x < 0 || x >= row || y < 0 || y >= col || grid[x].charAt(y) == '#')
//                         continue;
//                     char ch = grid[x].charAt(y);
//                     if (isKey(ch)) {
//                         k |= (1 << (ch - 'a'));
//                     }
//                     if (isLock(ch) && (k >> (ch - 'A') & 1 ) == 0)
//                         continue;
//                     if (visited.add(x + " " + y + " " + k))
//                         queue.offer(new Node(x, y, k));
//                 }
//             }
//             level++;
//         }
//         return -1;
//     }
    
//     public boolean isKey(char ch) {
//         return ch >= 'a' && ch <= 'f';
//     }
    
//     public boolean isLock(char ch) {
//         return ch >= 'A' && ch <= 'F';
//     }
// }


// class Node {
//     int i;
//     int j;
//     int key;
//     Node(int i, int j, int k) {
//         this.i = i;
//         this.j = j;
//         this.key = key;
//     }
// }

// https://leetcode.com/problems/shortest-path-to-get-all-keys/discuss/285969/Java-clean-bfs-with-some-thoughts-and-conclusions-about-%22find-distance%22


int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length, n = grid[0].length();
        int si = -1, sj = -1, k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    si = i;
                    sj = j;
                }
                if (isKey(c)) k++;
            }
        }
        Node start = new Node(si, sj, 0);
        Queue<Node> q = new LinkedList<>();
        q.offer(start);
        Set<String> visited = new HashSet<>();
        visited.add(si + " " +  sj + " " + 0);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                if (cur.key == (1 << k) - 1) return level;  // equi (1 * pow(2, key)) - 1
                for (int[] d : dirs) {
                    int x = cur.i + d[0];
                    int y = cur.j + d[1];
                    int key = cur.key;
                    if (!isValid(grid, x, y, m, n)) continue;
                    char c = grid[x].charAt(y);
                    if (isKey(c)) key |= (1 << (c - 'a'));
                    if (isLock(c) && (key >> (c - 'A') & 1) == 0) continue;
                    if (visited.add(x + " " + y + " " + key)) q.offer(new Node(x, y, key));
                }
            }
            level++;
        }
        return -1;
    }

    private boolean isLock(char c) {
        return c >= 'A' && c <= 'F';
    }

    private boolean isKey(char c) {
        return c >= 'a' && c <= 'f';
    }

    private boolean isValid(String[] grid, int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n && grid[i].charAt(j) != '#';
    }
 }

    class Node {
        int i, j, key;
        public Node(int i, int j, int key) {
            this.i = i;
            this.j = j;
            this.key = key;
        }
    }
