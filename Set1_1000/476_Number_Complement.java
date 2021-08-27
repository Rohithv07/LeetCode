class Solution {
    public int findComplement(int num) {
        int x = 1;
        while (num > x) {
            x = x * 2 + 1;
        }
        return x - num;
    }
}



// using bit masking

class Solution {
    public int findComplement(int num) {
        
        // here we take a mask of value 1 and to bitwise and
        int i = 0;
        int result = 0;
        while (num != 0) {
            if ((num & 1) == 0) {
                result += (1 << i);
            }
            i += 1;
            num = num >> 1; // right shif by 1 bit;
        }
        return result;
    }
}
