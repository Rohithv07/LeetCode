class Solution {
    public int compareVersion(String version1, String version2) {
        int i = 0;
        int j = 0;
        int length1 = version1.length();
        int length2 = version2.length();
        while (i < length1 || j < length2) {
            int temp1 = 0;
            int temp2 = 0;
            while (i < length1 && version1.charAt(i) != '.') {
                temp1 = temp1 * 10 + (version1.charAt(i++) - '0');
            }
            while (j < length2 && version2.charAt(j) != '.') {
                temp2 = temp2 * 10 + (version2.charAt(j++) - '0');
            }
            if (temp1 < temp2) {
                return -1;
            }
            if (temp1 > temp2) {
                return 1;
            }
            else {
                i++;
                j++;
            }
        }
        return 0;
    }
}