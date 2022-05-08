class Solution {
    public String largestGoodInteger(String num) {
        List<String> storeThreeDigit = new ArrayList<>();
        int length = num.length();
        int end = 0;
        for (end = 0; end + 2 < length; end++) {
            String currentSubstring = num.substring(end, end + 3);
            if (currentSubstring.charAt(0) == currentSubstring.charAt(1) && currentSubstring.charAt(1) == currentSubstring.charAt(2)) {
                storeThreeDigit.add(currentSubstring);
            }
        }
        if (storeThreeDigit.size() == 0) {
            return "";
        }
        Collections.sort(storeThreeDigit);
        int size = storeThreeDigit.size();
        return storeThreeDigit.get(size - 1);
    }
}