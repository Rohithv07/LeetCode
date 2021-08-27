class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList();
        if (digits == null || digits.length() == 0)
            return result;
        String [] numberMap = {
            "0",
            "1",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
            };
        dynamicHelper(result, digits, "", 0, numberMap);
        return result;
    }
    public void dynamicHelper(List<String> result, String digits, String current, int index, String[] numberMap){
        if (index == digits.length()){
            result.add(current);
            return;
        }
        String letter = numberMap[digits.charAt(index) - '0'];
        for (int i=0; i<letter.length(); i++){
            dynamicHelper(result, digits, current + letter.charAt(i), index+1, numberMap);
        }
    }
}
