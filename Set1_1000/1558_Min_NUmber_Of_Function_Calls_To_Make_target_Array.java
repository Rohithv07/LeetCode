/* My thought process:

So we are given an array of numbers with certain length and we need to do some operations, basically some function calls such that all the elements of that array becomes fully 0. So at first, I created a new array with fully 0 so that we can count the operations on this array to make it as nums array. So at starting we need to increment our element from 0 to 1 by incrementing and we have to increment our final result counter by 1. Now if its not 1 , I checked for even or odd and update by multiplying by 2 or incrementing by 1 with respective increment in counter. But this was not giving me the correct output when I coded it and run the code. So I decided to look on the hints and see if it can really help me. So in hint it says we can actually go from the nums array given and update it based on even or odd to get it into fully [0, 0, ..... ].

So correct code formation:

Ofcourse I started with a counter variable = 0, and a boolean varible to keep track that our array become fully 0 or not. So if the varible is false, then it indicates there are still elements to be 0, else all our numbers from the nums array become 0.
So we can have a while stament which runs until our boolean variable become true.

Inside Loop
- > Lets say we are good with zero, let boolean varibale = true;
- > Now iteraate through the array.
        - We can use a trick here that we can update tje counter based on the number even or not. If even we increment by 0 else            if its odd, we increment by 1.
        - Now update our number in the array by dividing by 2.
        - Once again check whether the number == 0, if not, set back our boolean variable into false, as there are still                    elements in the array to be 0.
- > After exiting from the array iteration, we again increment our counter by 1 as we have to do it because we have done some opeartions on it.
- > We exit from the while loop only if the boolean variable is true.

So atlast we will be having the final result with an extra increment 1, because even after exiting from the for loop after making every element in the array 0, we again increment our counter by 1 as we can clearly see from the code. So this extra increment by 1 have to be decremented and this value is returned.

*/




class Solution {
    public int minOperations(int[] nums) {
        int count = 0;
        boolean isZero = false;
        while (!isZero) {
            isZero = true;
            for (int i=0; i<nums.length; i++) {
                int evenOrOdd = nums[i] % 2;
                count += evenOrOdd;
                nums[i] /= 2;
                if (nums[i] != 0)
                    isZero = false;
            }
            count += 1;
        }
        return count-1;
    }
}
