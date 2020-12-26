// certain things that have to be genaralised is : 
// 1. There will be only one 0 at the final answer.
// 2. we need to count the number of 0's to the right and then 
// shift that many times to the right.
// for example : 01110010001 -> here the number of 0's after the leftmost zero = 5
// so we need to shift the leftmost 0 5 times to the right.
// 1111101111 this will be the answer.
// another thing to notice is that sometimes 0 will not be the first character.
// for example "101010111011001101000110010001100001111" and the first zero index is 1.
// so at the answer we need to insert our zero at the numberOfZero + firstZeroIndex position
// it is specified in my code.

// reference : https://www.youtube.com/watch?v=Of73lOvUFQM

class Solution {
    public String maximumBinaryString(String binary) {
        // count the number of zeros first after the left most 0.
        int firstZeroIndex = -1;
        int numberOfZeroAfter = 0;
        for (int i=0; i<binary.length(); i++) {
            if (binary.charAt(i) == '0') {
                if (firstZeroIndex == -1)
                    firstZeroIndex = i;
                else
                    numberOfZeroAfter += 1;
            }
        }
        // if there is only 1's in the given string, then just return the given input
        if (firstZeroIndex == -1)
            return binary;
        // if zero is not at the first index
        // then the place where we insert the zero will be firstZeroIndex + numberOfZeroAfter
        if (firstZeroIndex != 0)
            numberOfZeroAfter += firstZeroIndex;
        StringBuilder sb = new StringBuilder();
        // we populate with all 1 
        // now at the index of numberOfZeroAfter, we insert 0;
        for (int i=0; i<binary.length(); i++) {
            if (i == numberOfZeroAfter)
                sb.append("0");
            else
                sb.append("1");
        }
        return sb.toString();
    }
}
