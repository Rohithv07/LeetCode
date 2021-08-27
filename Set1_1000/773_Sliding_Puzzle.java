class Solution {
    public int slidingPuzzle(int[][] board) {
        int row = board.length;
        if (board == null || board.length == 0)
            return -1;
        int col = board[0].length;
        String target = "123450";
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                sb.append(board[i][j]);
            }
        }
        String starter = sb.toString();
        // we will be doing bfs and find min path to reach from start to target
        Queue<String> queue = new LinkedList<>();
        queue.offer(starter);
        Set<String> visited = new HashSet<>();
        visited.add(starter);
        // direction is taken as
        /* 0 1 2
           3 4 5    0 can move to right and down ie, index 1 and index 3(consider index from 0 to 5)
           
           1 0 2    0 can move to left right down, ie index 0, index 2, index 4
           3 4 5   
           
           1 2 0
           3 4 5   0 can move to left down, ie index 1, index 5
           
           1 2 3
           0 4 5   0 can move to top right, ie index 0, index 4
           
           1 2 3
           4 0 5   0 can move to top, left, right ie index 1, index 3, index 5
           
           1 2 3
           4 5 0   0 can move to top, left ie index 2, index 4 
           
        */
        int moves = 0;
        int [][] directions = new int [][] {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                String current = queue.poll();
                if (current.equals(target)) {
                    return moves;
                }
                // find the index of zero from the current string
                int indexOfZero = current.indexOf('0');
                // swap if possible
                for (int  dir : directions[indexOfZero]) {
                    String afterSwap = swap(current, indexOfZero, dir);
                    if (visited.contains(afterSwap))
                        continue;
                    visited.add(afterSwap);
                    queue.offer(afterSwap);
                }
            }
            moves += 1;
        }
        return -1;
    }
    
    public String swap(String current, int i, int j) {
        StringBuilder sb = new StringBuilder(current);
        sb.setCharAt(i, current.charAt(j));
        sb.setCharAt(j, current.charAt(i));
        return sb.toString();
    }
}
