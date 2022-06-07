class Solution {
    public int minimumLines(int[][] stockPrices) {
        int length = stockPrices.length;
        Arrays.sort(stockPrices, (stock1, stock2) -> Integer.compare(stock1[0], stock2[0]));
        int result = length - 1;
        for (int i = 1; i < length - 1; i++) {
            long slope1 = (stockPrices[i + 1][1] - stockPrices[i][1]) * (stockPrices[i][0] - stockPrices[i - 1][0]);
            long slope2 = (stockPrices[i + 1][0] - stockPrices[i][0]) * (stockPrices[i][1] - stockPrices[i - 1][1]);
            if (slope1 ==slope2) {
                result--;
            }
        }
        return result;
    }
}


/*
Note : 
A/B == C/D
int g1= gcd(A,B), g2= gcd(C,D);
if(A/g1==C/g2 &&  B/g1==D/g2)//If this condition is true means the [ A/B == C/D ] => This implementation will never give error for division comparison.
*/