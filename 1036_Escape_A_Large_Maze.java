// // we need to consider the source and target cannot be blocked

class Solution {
    private final int MAX_SIZE = (int) 1e6;
    private int [][] directions = new int [][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        if (blocked.length == 0)
            return true;
        Set<String> bSet = new HashSet<>();
        for (int [] block : blocked) {
            bSet.add(block[0] + "-" + block[1]);
        }
        return bfs(bSet, target, source) && bfs(bSet, source, target);
    }
    
    public boolean bfs(Set<String> bSet, int [] target, int [] source) {
        Set<String> visited = new HashSet<>();
        visited.add(source[0] + "-" + source[1]);
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(source);
        while (!queue.isEmpty()) {
            int [] current = queue.poll();
            int x = current[0];
            int y = current[1];
            for (int [] dir : directions) {
                int newX = dir[0] + x;
                int newY = dir[1] + y;
                String value = newX + "-" + newY;
                if (newX < 0 || newY < 0 || newX >= MAX_SIZE || newY >= MAX_SIZE || visited.contains(value) || bSet.contains(value))
                    continue;
                if (newX == target[0] && newY == target[1])
                    return true;
                visited.add(value);
                queue.offer(new int [] {newX, newY});
            }
            if (visited.size() == 20000)
                return true;
        }
        return false;
    }
}




