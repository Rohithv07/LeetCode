// we can make use of a sliding window of size k and check whether the elements inside the window have an average >= threshold


class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int length = arr.length;
        // lets decide our window;
        int start = 0;
        int end = k - 1;
        int count = 0;
        // lets make a loop until our end reaches the length of the array
        while (end != length) { 
            int sum = 0;
            // lets go through the elements inside the window and check for the avg >= threshold
            for (int i=start; i<=end; i++)
                sum += arr[i];
            int average = sum / k;
            if (average >= threshold)
                count += 1;
            end += 1;
            start += 1;
        }
        return count;
    }
}




Efficient One:

first calculate the sum of the first kth window. then take two pointers start = k and end = n-1 and take another variable "lets say s"and initialize it to 0.
Now every time you traverse from start to end. add nums[start] to your calculated sum and delete one element from starting. keeping the window constant of length K
and during that time only keep checking for the average if its greater or equal to threshold.

Here's my Code:

class Solution {
public int numOfSubarrays(int[] arr, int k, int threshold) {
	int n = arr.length, count = 0, sum = 0;
	for(int i = 0; i<k; i++)
	{
		sum += arr[i];
	}
	if(sum/k >= threshold) count++;
	int start = k, end = n-1, s = 0;
	while(start <= end)
	{
		sum += arr[start];
		sum -= arr[s];
		if(sum/k >= threshold) count++;
		start++;
		s++;
	}

    return count;
}
}	
