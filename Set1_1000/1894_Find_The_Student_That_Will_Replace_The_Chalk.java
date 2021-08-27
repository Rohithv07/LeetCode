class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        // find the total sum of the array
        // update the k value by taking k % sum
        // iterate through the array to check if there is any element where k < number
        // if yes return that index
        // else decrement k
        int length = chalk.length;
        long sum = 0;
        for (int number : chalk) {
            sum += number;
        }
        sum = k % sum; // as the sum may overflow
        long currentSum = 0;
        for (int i=0; i<length; i++) {
            currentSum += chalk[i];
            if (currentSum > sum)
                return i;
        }
        return length - 1;
    }
}
