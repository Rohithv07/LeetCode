class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 0;
        for (int i=s.length()-1; i>=0; i--) {
            char ch = s.charAt(i);
            int value = 0;
            switch(ch) {
                case 'I' : value = 1;break;
                case 'V' : value = 5;break;
                case 'X' : value = 10;break;
                case 'L' : value = 50;break;
                case 'C' : value = 100;break;
                case 'D' : value = 500;break;
                case 'M' : value = 1000;break; 
            }
            if (4 * value < result) {
                result -= value;
            }
            else {
                result += value;
            }
            // we can clear that by multiplying num by any number between 2 and 4 before comparing it to ans, since the numerals jump in value by increments of at least 5x.


        }
        return result;
    }
}