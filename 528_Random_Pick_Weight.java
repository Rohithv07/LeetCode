class Solution {

    private Random random;
    private int [] wsum;
    public Solution(int[] w) {
        this.random = new Random();
        for (int i=1; i<w.length; i++) {
            w[i] += w[i - 1];
        }
        this.wsum = w;
    }
    
    public int pickIndex() {
        // random = rand() % sum
        int length = wsum.length;
        int randomIndex = random.nextInt(wsum[length - 1]) + 1;
        int left = 0;
        int right = length - 1;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (wsum[middle] == randomIndex) {
                return middle;
            }
            else if (wsum[middle] < randomIndex) {
                left = middle + 1;
            }
            else {
                right = middle;
            }
        }
        return left;
    }
} // O(n + query * logn)

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */


/**
we are trying to pick a value in the range (0, maximum) in the wSum array above. In the example: wsum[] = {2,7,10,14}, idx tries to pick a random number between [0,14]. Since random.nextInt(wSums[len-1]) only picks random number between [0,13], the author added +1 to make it a random number between [0,14].
*/