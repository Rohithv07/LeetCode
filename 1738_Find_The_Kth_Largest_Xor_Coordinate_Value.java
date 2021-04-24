// ref : https://leetcode.com/problems/find-kth-largest-xor-coordinate-value/discuss/1032143/Java-Detailed-Explanation-DP-with-Graph-Demo
class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int row = matrix.length;
        int col = matrix[0].length;
        int [][] prefixXor = new int [row][col];
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                int x = (i > 0 ? prefixXor[i - 1][j] : 0);
                int y = (j > 0 ? prefixXor[i][j - 1] : 0);
                int z = (i > 0 && j > 0 ? prefixXor[i - 1][j - 1] : 0);
                prefixXor[i][j] = x ^ y ^ z ^ matrix[i][j];
                pq.add(prefixXor[i][j]);
                if (pq.size() > k)
                    pq.poll();
            }
        }
        return pq.poll();
    }
}
