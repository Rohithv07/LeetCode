/*
My thought process:
Here we can straight forward sort the two array and check whether each element is equal, if there exists a mismatch, then return false, else true. Here time complexity will nlogn.

But we can make it linear time by using an array to keep track of the count.
We traverse through the 2 arrays and increment count[target[i]] by 1 and decrement corresponding count[arr[i]] by 1.
Idea is.
for eg:target = [1, 2] arr=[2, 1]
Our count = [0, 0, ....] Initially.
So we increment count[target[0]] = count[1] = 1 and count[arr[0]] -= 1 = count [2] = -1
For next element, count[target[1]] = count[2] = -1+1 = 0 and count [arr[1]] -=1 = 1-1 = 0

So we check whether we got all the elements int he count array 0, if yes then we have matches for every element in the target.
If any of th eleemnt is not 0, then there is a mismatch and return false;

*/
// O(nlogn)
class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        for (int i=0; i<target.length; i++)
            if (target[i] != arr[i])
                return false;
        return true;
    }
}

// O(n)

class Solution {
    public boolean canBeEqual(int [] target, int [] arr) {
        int [] count = new int [1001];
        for (int i=0; i<target.length; i++) {
            count[target[i]] += 1;
            count[arr[i]] -= 1;
        }
        for (int c: count) {
            if (c != 0) // mismatch
                return false;
        }
        return true;
    }
}


