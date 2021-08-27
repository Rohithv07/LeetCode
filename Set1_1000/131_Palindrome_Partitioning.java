class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String>current = new ArrayList<>();
        helperFunction(result, current, s, 0);
        return result;
    }
    public void helperFunction(List<List<String>> result, List<String> current, String s, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }  
        for (int i=start; i<s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                current.add(s.substring(start, i+1));
                helperFunction(result, current, s, i+1);
                current.remove(current.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--))
                return false;
        }
        return true;
    }
}
