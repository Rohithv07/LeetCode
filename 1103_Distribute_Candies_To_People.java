class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int [] result = new int [num_people];
        int index = 0;
        int candyTrack = 1;
        while (candies > 0) {
            result[index % num_people] += candyTrack;
            index += 1;
            candies -= candyTrack;
            candyTrack += 1;
        }
        if (candies < 0) {
            result[(index - 1) % num_people] += candies;
        }
        return result;
    }
}







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
