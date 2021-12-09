// after understanding through the video for allocate pages : https://youtu.be/gYmWHvRHu-s

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        if (weights == null || weights.length == 0 || days < 0) {
            return -1;
        }
        int low = findMax(weights);
        int high = totalSum(weights);
        return binarySearch(weights, days, low, high);
    }
    
    public int binarySearch(int [] weights, int days, int low, int high) {
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (fitsInGivenWeight(weights, middle, days)) {
                high = middle - 1;
            }
            else {
                low = middle + 1;
            }
        }
        return low;
    }
    
    public boolean fitsInGivenWeight(int [] weights, int barrier, int days) {
        int daysTook = 1;
        int weightInADay = 0;
        for (int number : weights) {
            weightInADay += number;
            if (weightInADay > barrier) {
                daysTook++;
                weightInADay = number;
            }
            if (daysTook > days) {
                return false;
            }
        }
        return true;
    }
    
    public int findMax(int [] weights) {
        int max = -1;
        for (int number : weights) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }
    
    public int totalSum(int [] weights) {
        int sum = 0;
        for (int number : weights) {
            sum += number;
        }
        return sum;
    }
}











class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = totalSum(weights);
        while (left < right) {
            int middle = left + (right-left) / 2;
            if (leastWeight(middle, weights, D))
                right = middle;
            else
                left = middle + 1;
        }
        return left;
    }
    public boolean leastWeight(int middle, int [] weights, int D) {
        int answer = 1;
        int min = 0;
        for (int i=0; i<weights.length; i++) {
            min += weights[i];
            if (min > middle) {
                min = weights[i];
                answer += 1;
                if (answer > D)
                    return false;
            }
        }
        return true;
    }
    public int totalSum(int [] array) {
        int sum = 0;
        for (int i=0; i<array.length; i++) 
            sum += array[i];
        return sum;
    }
}
