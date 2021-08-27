class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        
        if (ransomNote == "" || magazine == "")
            return false;
        if (ransomNote.equals(magazine))
            return true;
        Map<Character, Integer> map = new HashMap<>();
        for (char ch: ransomNote.toCharArray()) 
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        for (char ch: magazine.toCharArray()) {
            if (map.containsKey(ch))
                map.put(ch, map.get(ch) - 1);
        }
        for (Character key: map.keySet()) {
            if (map.get(key) > 0)
                return false;
        }
        return true;
        
        // better approach without using hash
        int [] count = new int [26];
        for (char ch: ransomNote.toCharArray()) 
            count[ch-'a'] ++;
        for (char ch: magazine.toCharArray()) {
            count[ch-'a'] --;
        }
        for (int c : count)
            if (c > 0)
                return false;
        return true;
    }
}
