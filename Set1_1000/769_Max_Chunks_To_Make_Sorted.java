class Solution {
    public int maxChunksToSorted(int[] arr) {
        int count = 0;
        int sort = 0;
        for (int i=0; i<arr.length; i++) {
            sort = Math.max(sort, arr[i]);
            if (sort == i)
                count += 1;
        }
        return count;
    }
}

// same as the problem 1375
