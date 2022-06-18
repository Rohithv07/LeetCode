class Solution {
    public double calculateTax(int[][] brackets, int income) {
        if (income == 0) {
            return 0.0;
        }
        int previous = 0;
        double taxAmount = 0;
        for (int [] detail : brackets) {
            int upper = detail[0];
            int percent = detail[1];
            if (income >= upper) {
                taxAmount += (upper - previous) * (percent) / 100d;
                previous = upper;
            }
            else {
                taxAmount += (income - previous) * percent / 100d;
                break;
            }
        }
        return taxAmount;
    }
}