class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        // tracks after how many days the current task is eligible to be repeated again
        Map<Integer, Long> map = new HashMap<>();
        long result = 0;
        for (int task : tasks) {
            // find whether we need a break so that the task can be repeated in map.get(task)th day else continye next day
            result = Math.max(map.getOrDefault(task, 0l), result + 1);
            // next eligible day for the current task to be repeated
            map.put(task, result + space + 1);
        }
        return result;
    }
}