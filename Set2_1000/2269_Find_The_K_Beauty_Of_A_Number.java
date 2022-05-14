class Solution {
    public int divisorSubstrings(int num, int k) {
        int count = 0;
        String s = String.valueOf(num);
        int i = 0;
        for (i = 0; i + k < s.length(); i++) {
            String sub = s.substring(i, i + k);
            System.out.println(sub);
            int val = Integer.valueOf(sub);
            if (val == 0) {
                continue;
            }
            if (num % val == 0) {
                count++;
            }
        }
        String sub = s.substring(i);
        System.out.println(sub);
        int val = Integer.valueOf(sub);
        if (val != 0 && num % val == 0) {
            count++;
        }
        return count;
    }
}