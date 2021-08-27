// lets do the brute force here
// we can use 2 pointers, one pointing the last character initiallyy and another going from the start to the charcater before end and we check whether these two pointers values are equal.
// if we sees the equal, then we update our count by right - left - 1 and checks with a result varible and takes the max.
// we use two loops.
// at last we check whtehr our result is still the min_value then we need to return -1 else return the result

// now lets think of the optimal solution
// we can store the charcater and the index of that character.
// if the map do not have that character, then we just add the index as value for the key.
// otherwise, if take max(resultVariable, index - map.get(character) - 1)
// O(lengthOfString ^ 2)
class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        if (s.length() == 1)
            return 0;
        int count = 0;
        int result = Integer.MIN_VALUE;
        int left = 0;
        int right = s.length() - 1;
        while (right >= 0) { // O(lengthOfString)
            for (int i=left; i<right; i++) {
                if (s.charAt(i) == s.charAt(right)) { // O(lenghtOfString-1)
                    count = right - i - 1;
                    result = Math.max(result, count);
                }
            }
            right -= 1;
        }
        return result == Integer.MIN_VALUE ? -1 : result;
        
        
        
        // O(len(String))
        if (s.length() == 1)
            return 0;
        int result = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            char currentChar = s.charAt(i);
            if (map.containsKey(currentChar))
                result = Math.max(result, i - map.get(currentChar) - 1);
            else
                map.put(currentChar, i);
        }
        return result == Integer.MIN_VALUE ? -1 : result;
    }
}
