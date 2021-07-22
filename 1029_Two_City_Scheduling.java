class Solution {
    public int twoCitySchedCost(int[][] costs) {
        if (costs == null || costs.length == 0)
            return 0;
        // here we send all the people to A and calculate the total cost
        // now we calculate the refund, ie what happens if we send to B instead of A
        // this is find by calculating cost[1] - cost[0]
        // now if the value is -ve, then we have a huge refund to get and it will minimuize the cost
        // sort this array and take the refund amount until the people semd to A become equal to people send to B
        int totalAmountToAandB = 0;
        // we are sending everyone to A
        for (int [] cost : costs) {
            totalAmountToAandB += cost[0];
        }
        int length = costs.length;
        int [] refund = new int [length];
        int peopleToBeSend = length / 2; // these many amount of people to be send to either A or B
        // calculate the refund
        int index = 0;
        for (int [] cost : costs) {
            refund[index++] = cost[1] - cost[0];
        }
        // sort this refund and change the totalAmount
        Arrays.sort(refund);
        for (int i=0; i<peopleToBeSend; i++) {
            totalAmountToAandB += refund[i];
        }
        return totalAmountToAandB;
    }
}