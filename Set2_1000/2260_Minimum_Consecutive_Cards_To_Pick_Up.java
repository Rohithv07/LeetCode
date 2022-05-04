

// always go for the very last duplicate
class Solution {
    public int minimumCardPickup(int[] cards) {
        int length = cards.length;
        if (length == 1) {
            return -1;
        }
        int minimumConsecutiveCard = Integer.MAX_VALUE;
        Map<Integer, Integer> track = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int card = cards[i];
            if (track.containsKey(card)) {
                int current = i - track.get(card) + 1;
                minimumConsecutiveCard = Math.min(minimumConsecutiveCard, current);
            }
            track.put(card, i);
        }
        return minimumConsecutiveCard == Integer.MAX_VALUE ? -1 : minimumConsecutiveCard;
    }
}