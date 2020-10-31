class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int [] result = new int [queries.length];
        // the idea is to find the prefix xor of arr
        int [] prefix = new int [n+1];
        for (int i=0; i<n; i++)
            prefix[i+1] = prefix[i] ^ arr[i];
        for (int i=0; i<queries.length; i++) {
            result[i] = prefix[queries[i][1] + 1] ^ prefix[queries[i][0]];
        }
        return result;
    }
}
