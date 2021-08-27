/* My thought process
Here the idea is to make use of the gcd of numerator and denominator.
if gcd(numerator, denominator) == 1, then numerator/denominator is a valid fraction and we can add it into our result list.

Note:
Here we start traversing from denominator = 2 -> n and inner loop numerator = 1 -> denominator-1. 

*/


class Solution {
    public List<String> simplifiedFractions(int n) {
        if (n == 1)
            return new ArrayList<>();
        List<String> result = new ArrayList<>();
        for (int denominator=2; denominator<=n; denominator++) {
            for (int numerator=1; numerator<denominator; numerator++) {
                if (gcd(numerator, denominator) == 1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(numerator);
                    sb.append("/");
                    sb.append(denominator);
                    result.add(sb.toString());
                }
                
            }
        }
        return result;
    }
    public int gcd(int numerator, int denominator) {
        if (numerator == 0)
            return denominator;
        return gcd(denominator%numerator, numerator);
    }
}
