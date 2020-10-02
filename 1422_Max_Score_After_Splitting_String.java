// the idea is to find thr total count of 0 and 1
// the required answer will (zeroLeft-oneLeft) + totalOneCount
class Solution {
    public int maxScore(String s) {
        int max = Integer.MIN_VALUE;
        int zeroCount = 0;
        int oneCount = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '0')
                zeroCount += 1;
            else
                oneCount += 1;
            if (i != s.length()-1)
                max = Math.max(max, zeroCount - oneCount);
        }
        return max + oneCount;
    }
}
