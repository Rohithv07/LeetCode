class Solution {
    public int minimumRounds(int[] tasks) {
        if (tasks == null || tasks.length <= 1) {
            return -1;
        }
        Map<Integer, Integer> count = new HashMap<>();
        for (int task : tasks) {
            count.put(task, count.getOrDefault(task, 0) + 1);
        }
        int minRound = 0;
        for (int key : count.keySet()) {
            int currentCount = count.get(key);
            if (currentCount < 2) {
                return -1;
            }
            int rem = currentCount % 3;
            // if divisible by 3
            if (rem == 0) {
                minRound += currentCount / 3;
            }
            // for cases like 10, 28 etc
            else if (rem == 1) {
                while (currentCount != 4) {
                    currentCount -= 3;
                    minRound++;
                }
                minRound += 2;
            }
            // for other case
            else {
                minRound += (currentCount / 3) + 1;
            }
        }
        return minRound;
    }
}


// simple approach

class Solution {
    public int minimumRounds(int[] tasks) {
        if (tasks == null || tasks.length <= 1) {
            return -1;
        }
        Map<Integer, Integer> count = new HashMap<>();
        for (int task : tasks) {
            count.put(task, count.getOrDefault(task, 0) + 1);
        }
        int minRound = 0;
        for (int key : count.keySet()) {
            int currentCount = count.get(key);
            if (currentCount < 2) {
                return -1;
            }
            minRound += (currentCount + 2) / 3;
        }
        return minRound;
    }
}