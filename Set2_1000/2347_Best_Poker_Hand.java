class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        int [] countRank = new int [13];
        int [] countSuit = new int [4];
        for (int i = 0; i < ranks.length; i++) {
            int currentRank = ranks[i];
            char currentSuit = suits[i];
            countRank[currentRank - 1] += 1;
            countSuit[currentSuit - 'a'] += 1;
        }
        for (int i = 0; i < 4; i++) {
            if (countSuit[i] == 5) {
                return "Flush";
            }
        }
        for (int i = 0; i < 13; i++) {
            if (countRank[i] >= 3) {
                return "Three of a Kind";
            }
        }
        for (int i = 0; i < 13; i++) {
            if (countRank[i] == 2) {
                return "Pair";
            } 
        }
        return "High Card";
    }
}