class Solution {
    public int maxProduct(String[] words) {
        int length = words.length;
        int max = 0;
        int [] mask = new int [length];
        for (int i=0; i<length; i++) {
            int number = 0;
            for (char ch : words[i].toCharArray()) {
                number |= (1 << (ch - 'a'));
            }
            mask[i] = number;
            // System.out.println(mask[i]);
        }
        for (int i=0; i<length; i++) {
            if (mask[i] == max)
                continue;  // this line to increase time efficiency
            for (int j=0; j<length; j++) {
                if ((mask[i] & mask[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}
