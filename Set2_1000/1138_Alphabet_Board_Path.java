// If current letter is z, we must move upward before moving right; if next letter is z, must move left before moving downward.

class Solution {
    public String alphabetBoardPath(String target) {
        if (target == null || target.length() == 0) {
            return "";
        }
        int move = 0;
        int previousRow = 0;
        int previousCol = 0;
        StringBuilder sb = new StringBuilder();
        for (move=0; move<target.length(); move++) {
            int positionOfTarget = target.charAt(move) - 'a';
            int currentRow = positionOfTarget / 5;
            int currentCol = positionOfTarget % 5;
            // move left before moving down. this is to handle when we have z as next
            while (previousCol > currentCol) {
                sb.append("L");
                previousCol--;
            }
            // move up before moving right. this is to handle when we are at z
             while (previousRow > currentRow) {
                sb.append("U");
                previousRow--;
            }
            while (previousRow < currentRow) {
                sb.append("D");
                previousRow++;
            }
            while (previousCol < currentCol) {
                sb.append("R");
                previousCol++;
            }
            sb.append("!");
        }
        return sb.toString();
    }
}