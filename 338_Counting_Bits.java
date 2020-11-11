// when we have odd number , then number of set bits in x = 1 + number of set bits in y
// when we have even number, the number of set in bits in x = number of set bits in y
// right shifting is equivalent to dividing by 2
// 110 -> right shift >> 11
// 101 - > right shift >> 10



// so the idea is check for whether the number is even or not
// if even the number of bits for that number = number of bits of that (number / 2)
// if odd, the number of bits for that number = 1 + number of bits of that (number / 2);
class Solution {
    public int[] countBits(int num) {
        if (num == 0)
            return new int []{0};
        if (num == 1)
            return new int [] {0, 1};
        int [] result = new int [num+1];
        result[0] = 0;
        result[1] = 1;
        result[2] = 1;
        for (int i=3; i<=num; i++) {
            if (i % 2 == 0) {
                 result[i] = result[i/2];
            }
            else
                result[i] = 1 + result[i/2];
        }
        return result;
    }
}
