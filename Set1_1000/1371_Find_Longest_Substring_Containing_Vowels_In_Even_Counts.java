class Solution {
    public int findTheLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        // a = 0, e = 1, i = 2, o = 3, u = 4
        Map<Character, Integer> vowelToIndex = new HashMap<>();
        vowelToIndex.put('a', 0);
        vowelToIndex.put('e', 1);
        vowelToIndex.put('i', 2);
        vowelToIndex.put('o', 3);
        vowelToIndex.put('u', 4);
        Map<Integer, Integer> stateToIndex = new HashMap<>();
        stateToIndex.put(0, -1);
        int state = 0;
        int maxLength = 0;
        int length = s.length();
        for (int i=0; i<length; i++) {
            char current = s.charAt(i);
            if (vowelToIndex.containsKey(current)) {
                int digit = vowelToIndex.get(current);
                // flip the bit
                state ^= (1 << digit);
            }
            // state index map is updated only if this is a new state,
            // if we have seen this state before, we don't update it
            // as we want longest sub string.
            stateToIndex.putIfAbsent(state, i);
            /**
             * because we are flipping the bits, if that state already existed, it will
             * give us a sub string from that state to current same state with even
             * vowels.
             *
             * Assume the previous state is "0110" and the current state is also "0110",
             * it means all the even and odd bits are same. meaning the vowels existed in
             * between must have been even number of times.
             */
            maxLength = Math.max(maxLength, i - stateToIndex.get(state));
        }
        return maxLength;
    }
}