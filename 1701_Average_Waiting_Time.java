class Solution {
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        double sum = 0;
        int entry = 0;
        for (int [] cust : customers) {
            int arrival = cust[0];
            int time = cust[1];
            System.out.println(arrival + " " + time);
            if (entry <= arrival)
                entry = arrival + time;
            else
                entry += time;
            sum += entry - arrival;
        }
        return (sum / (double) n); 
    }
}
