1. Using Map:

class Solution {
    public int countCharacters(String[] words, String chars) {
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : chars.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (String word : words) {
            boolean isTestPassed = false;
            int [] count = new int [26];
            for (char ch : word.toCharArray()) {
                count[ch - 'a'] += 1;
            }
            for (char ch : word.toCharArray()) {
                if (!map.containsKey(ch)) {
                    isTestPassed = false;
                    break;
                }
                else if (map.containsKey(ch) && map.get(ch) >= count[ch - 'a']) 
                    isTestPassed = true;
                else if (map.containsKey(ch) && map.get(ch) < count[ch - 'a']) {
                    isTestPassed = false;
                    break;
                }
            }
            if (isTestPassed)
                result += word.length();
        }
        return result;
    }
}


2. Using Count array

class Solution {
    public int countCharacters(String[] words, String chars) {
        int result = 0;
        int [] occurance = new int [26];
        for (char ch : chars.toCharArray()) {
            occurance[ch - 'a'] += 1;
        }
        for (String word : words) {
            boolean isTestPassed = false;
            int [] count = occurance.clone();
            for (char ch : word.toCharArray()) {
                if (count[ch - 'a'] > 0) {
                    count[ch - 'a'] -= 1;
                    isTestPassed = true;
                }   
                else {
                    isTestPassed = false;
                    break;
                }
            }
            if (isTestPassed)
                result += word.length();
        }
        return result;
    }
}
