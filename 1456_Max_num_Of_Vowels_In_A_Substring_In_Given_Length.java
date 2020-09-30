class Solution {
    public int maxVowels(String s, int k) {
        if (s.length() < k)
            return 0;
        int vowelCount = 0;
        Map<Character, Boolean> map = new HashMap<>();
        map.put('a', true);
        map.put('e', true);
        map.put('i', true);
        map.put('o', true);
        map.put('u', true);
        int normalCount = 0;
        for (int i=0; i<k; i++) {
            if (map.containsKey(s.charAt(i)))
                normalCount += 1;
        }
        vowelCount = normalCount;
        for (int i=k; i<s.length(); i++) {
            if (map.containsKey(s.charAt(i-k)))
                normalCount -= 1;
            if (map.containsKey(s.charAt(i)))
                normalCount += 1;
            vowelCount = Math.max(vowelCount, normalCount);
        }
        return vowelCount;
    }
}
