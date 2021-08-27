/* My thought process
Here I first goes with the brute force solution where we iterate through the both arrays using nested loops and we check for the condition given from the question and if any is satisfied we decrease 1 from the total length of first array because we have to return number of elements arr1[i] such that there is not any element arr2[j] where |arr1[i]-arr2[j]| <= d.


The other approach after looking the hint is, we can sort the second array. we can clearly make use of a TreeSet to  which when we add elements will be sorted in ascending order.
Now we goes throgh the first array, finds the lower and upperbound possible and finds the subsets of this range.
If the set is empty, this indicates that our condition is met and we increment our count.

Finally return this count.


*/




// O(nlogm)
class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        TreeSet<Integer> tree = new TreeSet<>();
        for (int number: arr2) {
            tree.add(number);
        }
        for (int i=0; i<arr1.length; i++) {
            int leftValue = arr1[i] - d;
            int rightValue = arr1[i] + d;
            Set<Integer> set = tree.subSet(leftValue, rightValue+1);
            if (set.isEmpty())
                count += 1;
        }
        return count;
    }
}


// Brute force O(n^2)
class Solution {
    public int findTheDistanceValue(int [] arr1, int [] arr2, int d) {
        int count = arr1.length;
        for (int i=0; i<arr1.length; i++) {
            for (int j=0; j<arr2.length; j++) {
                if (Math.abs(arr1[i] - arr2[j]) <= d) {
                    count -= 1;
                    break;
                }
            }
        }
        return count;
    }
}
