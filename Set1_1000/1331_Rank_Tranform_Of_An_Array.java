// so we are given with an array of numbers and based on larger or smaller, they have ranks and we have to return an array by showing their ranks instead of the number.
// one of the possible way is to sort the array and store the sorted one into a new array.
// now they will be arranged based on the increasing order, ie from smaller rank to larger rank and we can easily get the rank from their index.
// one of the cases we need to consider is when there occurs duplicates, in that case we need to have the same rank.
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        //  create a temp array to store sorted result.
        int length = arr.length;
        int [] temp = new int[length];
        for (int i=0; i<length; i++)
            temp[i] = arr[i];
        Arrays.sort(temp);
        // now we have sorted temp array arranged according to the rank
        // now we need to keep track of the rank and for better lookup, lets make use of hashmap
        // here we add each element from temp to map and make its value as the mapsize()+1 if not exist
        // now we can modify the temp array or even the input array with the updated rank and return the result.
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int t: temp)
            map.putIfAbsent(t, map.size()+1);
        for (int i=0; i<length; i++)
            // store the value of current input array number into the temp array
            temp[i] = map.get(arr[i]);
        return temp;
    }
}
