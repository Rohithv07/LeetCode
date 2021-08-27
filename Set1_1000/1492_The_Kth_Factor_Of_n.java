/* My thought process
We are given 2 integers n and k and we need to find the factor from 1 to n and need to find the k th factor of n. If k > the number of factor of n, then just return -1.

So here since no constrain about space is given, we can just use a List to store all the factors.
Then after storing, we can make our initial check that whehter the k > number of factor.
We can do this by comparing k and size of list. If this holds true, return -1.
Else just return list.get(k-1) 

*/

class Solution {
    public int kthFactor(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            if (n%i == 0)
                list.add(i);
        }
        if (list.size() < k)
            return -1;
        return list.get(k-1);
    }
}
