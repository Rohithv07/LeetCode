class Solution {
    public int getLucky(String s, int k) {
        if (s == null || s.length() == 0)
            return 0;
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            sb.append(ch - 'a' + 1);
        }
        for (int i=0; i<k; i++) {
            String current = sb.toString();
            int sum = 0;
            for (char ch : current.toCharArray()) {
                sum += ch - '0';
            }
            sb = new StringBuilder();
            sb.append(sum);
            current = sb.toString();
        }
        return Integer.parseInt(sb.toString());
    }
}

// O(n + k * numberofnewlyformedstring length)

// efficient approach

// O(n + k lognumber)
class Solution {
    public int getLucky(String s, int k) {
        if (s == null || s.length() == 0)
            return 0;
        int sum = 0;
        int temp = 0;
        // k to z handle
        for (char ch : s.toCharArray()) {
            int number = ch - 'a' + 1;
            sum += number % 10 + number / 10;
        }
        while (k - 1 > 0 && sum > 9) {
            temp = 0;
            while (sum > 0) {
                temp += sum % 10;
                sum = sum / 10;
            }
            sum = temp;
            k--;
        }
        return sum;
    }
}

