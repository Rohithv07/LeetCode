class Solution {
    public int lengthOfLongestSubstring(String s) {
        int first_pointer = 0;
        int second_pointer = 0, max = 0;
        HashSet<Character> hash = new HashSet<>();
        while(second_pointer < s.length()){
            if(!hash.contains(s.charAt(second_pointer))){
                hash.add(s.charAt(second_pointer));
                second_pointer ++;
                max = Math.max(hash.size(), max);
            }
            else{
                hash.remove(s.charAt(first_pointer));
                first_pointer ++;
            }
        }
    return max;
    }
    
    
}
