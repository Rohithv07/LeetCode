class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        char [] current = S.toCharArray();
        helperFunction(result, current, 0);
        return result;
    }
    public void helperFunction(List<String> result, char [] current, int start) {
        if (start == current.length) {
            result.add(new String(current));
            return;
        }
        if (current[start] >= '0' && current[start] <= '9') {
            helperFunction(result, current, start + 1);
            return;
        }
        current[start] = Character.toLowerCase(current[start]); // for lowercase
        helperFunction(result, current, start + 1);
        
        current[start] = Character.toUpperCase(current[start]); // for uppercase
        helperFunction(result, current, start + 1);
    }
}
