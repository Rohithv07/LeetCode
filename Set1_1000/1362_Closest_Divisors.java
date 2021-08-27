/*if (number + 1) % i == 0, return new int[]{i, (number+1)/i}
if (number + 2) % i == 0, return new int[]{i, (number+2)/i}
*/

class Solution {
    public int[] closestDivisors(int num) {
        for (int i=(int)Math.sqrt(num+2); i>0; i--) {
            if ((num+1) % i == 0)
                return new int[]{i, (num+1)/i};
            if ((num+2) % i == 0)
                return new int[]{i, (num+2)/i};
        }
        return new int[]{};
    }
}
