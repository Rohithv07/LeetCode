class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        if (s == null || s.length() == 0) {
            return new int []{};
        }
        int length = s.length();
        int [] possibleMove = new int [length];
        for (int i = 0; i < length; i++) {
            int countOfPossibleMove = 0;
            int startingRow = startPos[0];
            int startingCol = startPos[1];
            for (int j = i; j < length; j++) {
                char ch = s.charAt(j);
                if (ch == 'R') {
                    if (startingCol + 1 >= n) {
                        break;
                    }
                    startingCol += 1;
                }
                else if (ch == 'L') {
                    if (startingCol - 1 < 0) {
                        break;
                    }
                    startingCol -= 1;
                }
                else if (ch == 'U') {
                    if (startingRow - 1 < 0) {
                        break;
                    }
                    startingRow -= 1;
                }
                else if (ch == 'D') {
                    if (startingRow + 1 >= n) {
                        break;
                    }
                    startingRow += 1;
                }
                countOfPossibleMove += 1;
            }
            possibleMove[i] = countOfPossibleMove;
        }
        return possibleMove;
    }
}