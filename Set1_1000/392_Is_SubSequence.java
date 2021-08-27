class Solution {
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c: s.toCharArray()) {
            index = t.indexOf(c, index+1);
            if (index == -1)
                return false;
        }
        return true;
    }
}

// https://youtu.be/PwQnydsKk_I

class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0)
            return true; //empty string is subsequence of another string
        if (t == null || t.length() == 0)
            return false;
        int pointerA = 0;
        int pointerB = 0;
        while (pointerA < s.length() && pointerB < t.length()) {
            if (s.charAt(pointerA) == t.charAt(pointerB)) {
                pointerA += 1;
            }
            pointerB += 1;
        }
        return pointerA == s.length();
        
        // follow - up using binary search tlogt
        
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i=0; i<t.length(); i++) {
            char ch = t.charAt(i);
            List<Integer> currentCharIndex = map.getOrDefault(ch, new ArrayList<>());
            currentCharIndex.add(i);
            map.put(ch, currentCharIndex);
        }
        int lastPosition = -1;
        for (char ch : s.toCharArray()) {
            if (!map.containsKey(ch))
                return false;
            List<Integer> index = map.get(ch);
            int findIndexOfCharacter = binarySearch(index, lastPosition);
            if (findIndexOfCharacter == -1)
                return false;
            lastPosition = findIndexOfCharacter;
        }
        return true;
    }
    
    public int binarySearch(List<Integer> index, int lastPosition) {
        int low = 0;
        int high = index.size() - 1;
        int result = -1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (index.get(middle) > lastPosition) {
                result = index.get(middle);
                high = middle - 1;
            }
            else {
                low = middle + 1;
            }
        }
        return result;
    }
}