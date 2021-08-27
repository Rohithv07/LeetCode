class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int status = minutesToTest / minutesToDie + 1;
        int numberOfPigs = 0;
        while (Math.pow(status, numberOfPigs) < buckets)
            numberOfPigs += 1;
        return numberOfPigs;
    }
}
