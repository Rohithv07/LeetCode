class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        if (coins < costs[0])
            return 0;
        int sum = 0;
        for (int number : costs) {
            sum += number;
        }
        if (sum <= coins)
            return costs.length;
        sum = 0;
        int count = 0;
        for (int number : costs) {
            sum += number;
            if (sum > coins) {
                break;
            }
            else {
                count += 1;
            }
        }
        return count;
    }
}
