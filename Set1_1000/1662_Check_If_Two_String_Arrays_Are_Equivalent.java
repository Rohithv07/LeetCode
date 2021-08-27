class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder buildFirstString = new StringBuilder();
        StringBuilder buildSecondString = new StringBuilder();
        for (String s : word1) {
            buildFirstString.append(s);
        }
        for (String s : word2)
            buildSecondString.append(s);
        return buildFirstString.toString().equals(buildSecondString.toString());
    }
}
