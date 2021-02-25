class Solution {
    public int[] minOperations(String boxes) {
        int length = boxes.length();
        int [] result = new int [length];
        int count = 0;
        int output = 0;
        for (int i=0; i<length; i++) {
            result[i] += output;
            count += boxes.charAt(i) == '1' ? 1 : 0;
            output += count;
        }
        output = 0;
        count = 0;
        for (int i=length - 1; i>=0; i--) {
            result[i] += output;
            count += boxes.charAt(i) == '1' ? 1 : 0;
            output += count;
        }
        return result;
    }
}

/*

1 -> contains    0 -> empty

s = 1 1 0

-> at index 0 -> we already have 1 ball + we need to move the adjacent ball to that -> 1 operation
-> at index 1 -> we already have 1 ball + we need to mobe the adjacent ball to that -> 1 operation
-> at index 2 -> empty ball, from 0th index, we need to do 2 operations to put it in index 2 + 1 operation for the 1st index ball to move to index 2 -> 3 operation

result = [1, 1, 3]


So the scenario is move from left to right and increment the output to the respective index.
output = 0 and count = 0 initially
if (char == 1)
 count is increment with 1 else with 0
and this count added to output

Now this is from left to right
Same way to the right to left
reinitialize output = 0 count = 0
and repeat the above step


*/
