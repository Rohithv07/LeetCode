class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        // store the count of 0s and 1s in an array of size 2
        int [] countThem = new int [2];
        for (int number : students)
            countThem[number] += 1;
        for (int i=0; i<sandwiches.length; i++) {
            if (--countThem[sandwiches[i]] < 0)
                return sandwiches.length - i;
        }
        return 0;
    }
}
