class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0)
            return Integer.MIN_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                pq.add(matrix[i][j]);
                if (pq.size() > k)
                    pq.poll();
            }
        }
        return pq.poll();
    }
}