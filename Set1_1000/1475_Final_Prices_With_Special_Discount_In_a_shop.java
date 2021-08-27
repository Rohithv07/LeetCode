/*
My thought process:

SO here the constraints given is very small so we can go with the brute force solution.
-> Traverse from  i=0 -> length and innerloop from j=i+1 -> length.
-> If we find a price[j] <= price[i], then store the difference into the corresponding index and break from inner loop.
-> Else just store price[i].

Here when I run the above code I got the last element of my output array as 0 and not showing the last element.So I just stored the last element into the result array and thats the problem.

This can also be implemented using stack.
-> Store the index of the price if stack is empty or prices[stackTopElement] >= prices[i].
-> Else store the corresponding index value inplace with the difference.

Now just return the array and thats the problem.
*/


//O(n^2)
class Solution {
    public int[] finalPrices(int[] prices) {
        int length = prices.length;
        int [] result = new int [length];
        for (int i=0; i<length; i++) {
            for (int j=i+1; j<length; j++) {
                if (prices[j] <= prices[i]) {
                    result[i] = prices[i] - prices[j];
                    break;
                }
                else {
                    result[i] = prices[i];
                }
            }
        }
        result[length-1] = prices[length-1]; 
        return result;
    }
}

//O(n)
class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i])
                prices[stack.pop()] -= prices[i];
            stack.push(i);
        }
        return prices;
    }
}
