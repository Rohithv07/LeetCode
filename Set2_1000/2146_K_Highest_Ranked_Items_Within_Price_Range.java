class Solution {
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        if (grid == null || grid.length == 0 || grid[start[0]][start[1]] == 0) {
            return new ArrayList<>();
        }
        int row = grid.length;
        int col = grid[0].length;
        int low = pricing[0];
        int high = pricing[1];
        List<List<Integer>> result = new ArrayList<>();
        boolean [][] visited = new boolean [row][col];
        visited[start[0]][start[1]] = true;
        int [][] direction = new int [][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        PriorityQueue<Node> maxHeap = new PriorityQueue<>(new MyComparator());
        maxHeap.offer(new Node(start[0], start[1], 0, grid[start[0]][start[1]]));
        while (!maxHeap.isEmpty() && result.size() < k) {
            int size = maxHeap.size();
            for (int i=0; i<size; i++) {
                Node currentNode = maxHeap.poll();
                int currentRow = currentNode.row;
                int currentCol = currentNode.col;
                int currentDistance = currentNode.distance;
                int currentPrice = grid[currentRow][currentCol];
                if (currentPrice >= low && currentPrice <= high && result.size() < k) {
                    result.add(Arrays.asList(currentRow, currentCol));
                }
                for (int [] dir : direction) {
                    int nextRow = dir[0] + currentRow;
                    int nextCol = dir[1] + currentCol;
                    if (nextRow < 0 || nextCol < 0 || nextRow >= row || nextCol >= col || visited[nextRow][nextCol] || grid[nextRow][nextCol] == 0) {
                        continue;
                    }
                    visited[nextRow][nextCol] = true;
                    maxHeap.offer(new Node(nextRow, nextCol, currentDistance + 1, grid[nextRow][nextCol]));
                }
            }
        }
        return result;
    }
}

class Node {
    int row;
    int col;
    int distance;
    int price;
    public Node(int row, int col, int distance, int price) {
        this.row = row;
        this.col = col;
        this.distance = distance;
        this.price = price;
    }
}

class MyComparator implements Comparator<Node> {
    @Override
    public int compare(Node node1, Node node2) {
        if (node1.distance == node2.distance) {
            if (node1.price == node2.price) {
                if (node1.row == node2.row) {
                    return Integer.compare(node1.col, node2.col);
                }
                return Integer.compare(node1.row, node2.row);
            }
            return Integer.compare(node1.price, node2.price);
        }
        return Integer.compare(node1.distance, node2.distance);
    }
}
