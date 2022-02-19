class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        if (finalSum % 2 == 1) {
            return new LinkedList<>();
        }
        LinkedList<Long> result = new LinkedList<>();
        long starting = 2;
        while (starting <= finalSum) {
            result.offer(starting);
            finalSum -= starting;
            starting += 2;
        }
        result.offer(finalSum + result.pollLast());
        return result;
    }
}