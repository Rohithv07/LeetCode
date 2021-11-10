/*
Intuition

In a group of K adjacent empty seats between two people, the answer is (K+1) / 2.

Algorithm

For each group of K empty seats between two people, we can take into account the candidate answer (K+1) / 2.

For groups of empty seats between the edge of the row and one other person, the answer is K, and we should take into account those answers too.

*/

class Solution {
    public int maxDistToClosest(int[] seats) {
        if (seats.length == 2)
            return 1;
        int answer = 0;
        int k = 0;
        for (int i=0; i<seats.length; i++) {
            if (seats[i] == 1)
                k = 0;
            else {
                k += 1;
                answer = Math.max(answer, (k+1)/2);
            }
        }
        for (int i=0; i<seats.length; i++) {
            if (seats[i] == 1) {
                answer = Math.max(answer, i);
                break;
            }
        }
        for (int i=seats.length-1; i>=0; i--) {
            if (seats[i] == 1) {
                answer = Math.max(answer, seats.length - 1 - i);
                break;
            }
        }
        return answer;
    }
}


// first approach that will come to our mind


class Solution {
    public int maxDistToClosest(int[] seats) {
        if (seats == null || seats.length == 0) {
            return 0;
        }
        int length = seats.length;
        int [] leftToRight = new int [length];
        int [] rightToLeft = new int [length];
        Arrays.fill(leftToRight, length);
        Arrays.fill(rightToLeft, length);
        int answer = 0;
        for (int i=0; i<length; i++) {
            if (seats[i] == 1) {
                leftToRight[i] = 0;
            }
            else if (i > 0) {
                leftToRight[i] = 1 + leftToRight[i - 1];
            }
        }
        for (int i=length-1; i>=0; i--) {
            if (seats[i] == 1) {
                rightToLeft[i] = 0;
            }
            else if (i < length - 1) {
                rightToLeft[i] = 1 + rightToLeft[i + 1];
            }
        }
        for (int i=0; i<length; i++) {
            if (seats[i] == 0) {
                answer = Math.max(answer, Math.min(leftToRight[i], rightToLeft[i]));
            }
        }
        return answer;
    }
}