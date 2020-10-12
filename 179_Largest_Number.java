class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return "";
        String [] array = new String[nums.length];
        for (int i=0; i<nums.length; i++)
            array[i] = String.valueOf(nums[i]);
        Arrays.sort(array, (a1, a2) -> ((a2+a1).compareTo(a1+a2)));
        if (array[0].equals("0"))
            return "0";
        StringBuilder sb = new StringBuilder();
        for (String s: array)
            sb.append(s);
        return sb.toString();
        
    }
}
