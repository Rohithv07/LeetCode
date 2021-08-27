/*
This explanation is taken from discussion section and this is implemented.
Init: 
- left_sum = 6
- right sum = 0
- max = left_sum = 6

- Swap i = 0:
left_card_value = cardPoints[k - 1 - i] = cardPoints[3 - 1.- 0] = cardPoints[2] = 3.
right_card_value = cardPoints[n - 1 - i] = cardPoints[7 - 1 - 0] = cardPoints[6] = 1. (this is right most card)
=> left_sum = left_sum - left_card_value = 6 - 3 = 3
=> right_sum = right_sum + right_card_value = 0 + 1 = 1
=> max = Math.max(max, left_sum + right_sum) = Math.max(3 + 1, 6) = 6.

- Swap i = 1;
left_card_value = cardPoints[k - 1 - i] = cardPoints[3 - 1 - 1] = cardPoints[1] = 2.
right_card_value = cardPoints[n - 1 - i] = cardPoints[7 - 1 - 1] = cardPoints[5] = 6. (this is right most card)
=> left_sum = left_sum - left_card_value = 3 - 2 = 1
=> right_sum = right_sum + right_card_value = 1 + 6 = 7
=> max = Math.max(max, left_sum + right_sum) = Math.max(1 + 7, 6) = 8.

- Swap i = 2;
left_card_value = cardPoints[k - 1 - i] = cardPoints[3 - 1 - 2] = cardPoints[0] = 1.
right_card_value = cardPoints[n - 1 - i] = cardPoints[7 - 1 - 2] = cardPoints[4] = 5. (this is right most card)
=> left_sum = left_sum - left_card_value = 1 - 1 = 0.   (none of left card is selected)
=> right_sum = right_sum + right_card_value = 7 + 5 = 12 (all right cards)
=> max = Math.max(max, left_sum + right_sum) = Math.max(0 + 12, 8) = 12.

=> Return: max = 12

*/

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int length = cardPoints.length;
        int leftSum = 0;
        int rightSum = 0;
        for (int i=0; i<k; i++) {
            leftSum += cardPoints[i];
        }
        int maxPoint = leftSum;
        for (int i=0; i<k; i++) {
            leftSum -= cardPoints[k-1-i];
            rightSum += cardPoints[length-1-i];
            maxPoint = Math.max(maxPoint, leftSum+rightSum);
        }
        return maxPoint;
    }
}
