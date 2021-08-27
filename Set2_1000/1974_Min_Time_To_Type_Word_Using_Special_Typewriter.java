class Solution {
    public int minTimeToType(String word) {
        if (word == null || word.length() == 0)
            return 0;
        char pointer = 'a';
        int length = word.length();
        int time = length;
        for (int i=0; i<length; i++) {
            char current = word.charAt(i);
            int distance = Math.abs(pointer - current);
            // min(clock, anti-clock)
            time += Math.min(distance, 26-distance);
            pointer = current;
        }
        return time;
    }
}