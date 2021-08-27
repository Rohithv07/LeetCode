class Solution {
    List<String> result = new ArrayList();
    public List<String> generateParenthesis(int n) {
        backTrack("", 0, 0, n);
        return result;
    }
    public void backTrack(String s, int left, int right, int n){
        if (s.length() == 2 * n){
            result.add(s);
            return;
        }
        if (left < n)
            backTrack(s + '(', left+1, right, n);
        if (right < left)
            backTrack(s + ')', left, right+1, n);
    }
}
