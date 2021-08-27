/*
From java docs:

void add(int index,
         E element)
Inserts the specified element at the specified position in this list (optional operation). Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
Parameters:
index - index at which the specified element is to be inserted
element - element to be inserted

*/
class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        // cretae the output array
        int [] output = new int[nums.length];
        // create a list to store nums to corresponding index
        List<Integer> store = new ArrayList<>();
        for (int i=0; i<nums.length; i++)
            store.add(index[i], nums[i]);   // O(n^2) as adding to list take O(n) * we are doing it n times. So O(n * n)
        // now for the respective index, store the corresponding value from the list
        for (int i=0; i<nums.length; i++) 
            output[i] = store.get(i);
        return output;
    }
}
