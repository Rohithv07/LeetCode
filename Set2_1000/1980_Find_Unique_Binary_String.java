// https://leetcode.com/problems/find-unique-binary-string/discuss/1418687/Detailed-Explanation-O(N)-Java-C%2B%2B-Python-short-concise-code-Cantor's-Diagonalization
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        if (nums == null || nums.length == 0)
            return "";
        StringBuilder unique = new StringBuilder();
        int length = nums.length;
        for (int i=0; i<length; i++) {
            unique.append(nums[i].charAt(i) == '0' ? '1' : '0');
        }
        return unique.toString();
    }
}