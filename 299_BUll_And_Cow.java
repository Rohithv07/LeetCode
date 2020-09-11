class Solution {
    public String getHint(String secret, String guess) {
        int cow = 0;
        int bull = 0;
        int [] count = new int [10];
        int length = secret.length();
        for (int i=0; i<length; i++) {
            count[secret.charAt(i) - '0'] += 1;
        }
        for (int i=0; i<length; i++) {
            count[guess.charAt(i) - '0'] -= 1;
            if (count[guess.charAt(i) - '0'] >= 0) {
                cow += 1;
            }
        }
        for (int i=0; i<length; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                cow -= 1;
                bull += 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bull);
        sb.append("A");
        sb.append(cow);
        sb.append("B");
        return sb.toString();
    }
}
