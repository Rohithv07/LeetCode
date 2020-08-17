class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int [] array = new int[num_people];
        int i = 0;
        int loop = 0;
        
        while (candies > 0){
            if (i == num_people){
                i = 0;
                loop += 1;
            }
            int numberOfCandiesLeft = (loop * num_people) + (i + 1);
            if (candies - numberOfCandiesLeft < 0){
                array[i] += candies;
            }
            else{
                array[i] += numberOfCandiesLeft;
            }
            i ++;
            candies -= numberOfCandiesLeft;
        }
        return array;
    }
}
