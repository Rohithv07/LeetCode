class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        int length = nums.length;
        int candidate1 = -1;
        int candidate2 = -1;
        int counter1 = 0;
        int counter2 = 0;
        for (int number : nums) {
            if (number == candidate1) {
                counter1++;
            }
            else if (number == candidate2) {
                counter2++;
            }
            else if (counter1 == 0) {
                candidate1 = number;
                counter1 = 1;
            }
            else if (counter2 == 0) {
                candidate2 = number;
                counter2 = 1;
            }
            else {
                counter1--;
                counter2--;
            }
        }
        //System.out.println(candidate1 + " " + candidate2);
        counter1 = 0;
        counter2 = 0;
        for (int number : nums) {
            if (number == candidate1) {
                counter1++;
            }
            else if (number == candidate2) {
                counter2++;
            }
        }
        if (counter1 > length / 3) {
            result.add(candidate1);
        }
        if (counter2 > length / 3) {
            result.add(candidate2);
        }
        return result;
    }
}