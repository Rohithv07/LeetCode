class Solution {
    public int minimumLength(String s) {
        int length = s.length();
        if (length == 1)
            return 1;
        int left = 0;
        int right = length - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return right - left + 1;
            }
            // we have to consider prefix and suffix and remove them if they are equal 
            // we can do that as many times as possible
            while (left + 1 < right && s.charAt(left) == s.charAt(left + 1)) {
                left += 1;
            }
            while (left < right - 1 && s.charAt(right) == s.charAt(right - 1)) {
                right -= 1;
            }
            left += 1;
            right -= 1;
        }
        return right - left + 1;
    }
}
