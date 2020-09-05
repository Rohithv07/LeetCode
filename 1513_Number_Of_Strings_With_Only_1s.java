class Solution {
    public int numSub(String s) {
        if (s.length() == 0)
            return 0;
        int count = 0;
        int modulus = (int)1e9 + 7;
        int result = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '1')
                count += 1;
            else
                count = 0;
            result = (result + count) % modulus;
            System.out.println(result);
        }
        return result;
    }
}
