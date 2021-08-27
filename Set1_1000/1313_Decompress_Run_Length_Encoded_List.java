// lets start by the brute force here.
// go through the array twice and add that much value into the tempList.

class Solution {
    public int[] decompressRLElist(int[] nums) {
       
        List<Integer> tempArray = new ArrayList<>();
        int length = nums.length;
        for (int i=0; i<length; i+=2) { // O(length/2)
            int freq = nums[i];
            int val = nums[i+1];
            for (int j=0; j<freq; j++) { // O(freq)
                tempArray.add(val);
            }
        }
        int [] finalResult = new int [tempArray.size()];
        for (int i=0; i<tempArray.size(); i++)
            finalResult[i] = tempArray.get(i);
        return finalResult;
        
        // O(length/2 * frequency) => O(length * frequency)
        
        // now lets try to optimize it. 
        // here the size of the result array will be the sum of the freq position from the input array.
        // then we fill the result array with the value needed and finallu return that array
        int finalSize = 0;
        for (int i=0; i<nums.length; i+=2) //O(length/2)
            finalSize += nums[i];
        int [] result = new int [finalSize];
        int index = 0;
        for (int i=0; i<nums.length; i+=2) { // O(length / 2)
            Arrays.fill(result, index, index+nums[i], nums[i+1]);  // Arrays.fill(array, start, end, val) is the syntax
            index += nums[i];
        }
        return result;
        // O(length)
    }
}
