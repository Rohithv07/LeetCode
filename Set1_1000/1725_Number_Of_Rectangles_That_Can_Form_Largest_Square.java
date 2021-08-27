class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        // find the minimum, length or if its width
        // find the maximum value among them and return the count of occurance of numbers >= max
        int [] sidesArray = new int [rectangles.length];
        int index = 0;
        for (int [] sides : rectangles) {
            sidesArray[index++] = Math.min(sides[0], sides[1]);
        }
        int count = 0;
        int max = Integer.MIN_VALUE;
        for (int number : sidesArray) {
            max = Math.max(max, number);
        }
        for (int number : sidesArray) {
            if (number >= max)
                count += 1;
        }
        return count;
    }
}
1 pass Solution
class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int count = 0;
        int max = Integer.MIN_VALUE;
        for (int [] side : rectangles) {
            int ourSide = Math.min(side[0], side[1]);
            if (ourSide > max) {
                count = 1;
                max = ourSide;
            }
            else if (ourSide == max)
                count += 1;
        }
        return count;
    }
}
