class Solution {
    public int maximumWealth(int[][] accounts) {
        int maximumWealth = 1;
        int row = accounts.length;
        int col = accounts[0].length;
        for (int i=0; i<row; i++) {
            int currentCustomerWealth = 0;
            for (int j=0; j<col; j++) {
                currentCustomerWealth += accounts[i][j];
            }
            maximumWealth = Math.max(maximumWealth, currentCustomerWealth);
        }
        return maximumWealth;
    }
}