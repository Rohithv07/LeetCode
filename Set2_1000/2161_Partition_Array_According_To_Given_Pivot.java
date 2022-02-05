class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        if (nums.length == 1) {
            return nums;
        }
        List<Integer> lessThanPivot = new ArrayList<>();
        List<Integer> greaterThanPivot = new ArrayList<>();
        int less = 0;
        int more = 0;
        int count = 0;
        for (int number : nums) {
            if (pivot > number) {
                lessThanPivot.add(number);
                less++;
            }
            else if (pivot == number) {
                count++;
            }
            else {
                greaterThanPivot.add(number);
                more++;
            }
            
        }
        int length = nums.length;
        int [] result = new int [length];
        //System.out.println(less + " " + count + " " + more);
        int index = less;
        int temp = count;
        while (count-- > 0) {
            result[index++] = pivot;
        }
        index = 0;
        for (int number : lessThanPivot) {
            result[index++] = number;
        }
        //System.out.println(index);
        index += temp;
        System.out.println(index);
        for (int number : greaterThanPivot) {
            result[index++] = number;
        }
         return result;
    }
}