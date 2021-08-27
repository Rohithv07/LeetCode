// here we just need to find the maximum number given from the string and that is the answer as we need to add that much of 1 as steps to get the required answer.
// for eg: "9", we need 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 = 9 steps

class Solution {
    public int minPartitions(String n) {
        int max = 0;
        for (char ch: n.toCharArray()) {
            int currentNumber = Integer.parseInt(String.valueOf(ch));
            max = Math.max(max, currentNumber);
        }
        return max;
    }
}
