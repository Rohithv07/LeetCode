class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        int length = student_id.length;
        Set<String> onlyPositive = new HashSet<>();
        Set<String> onlyNegative = new HashSet<>();
        fillHashSet(positive_feedback, onlyPositive);
        fillHashSet(negative_feedback, onlyNegative);
        long [] score = new long [length];
        List<Integer> result = new ArrayList<>();
        int scoreIndex = 0;
        for (String s : report) {
            long currentScore = 0;
            String [] split = s.split("\\s");
            for (String splitted : split) {
                if (onlyNegative.contains(splitted)) {
                    currentScore--;
                }
                else if (onlyPositive.contains(splitted)) {
                    currentScore += 3;
                }
            }
            score[scoreIndex++] = currentScore;
        }
        Store[] idAndScore = new Store[length];
        for (int i = 0; i < length; i++) {
            int id = student_id[i];
            long currentStudentScore = score[i];
            idAndScore[i] = new Store(id, currentStudentScore);
        }
        // do just reverse in minheap
        // we don't want the minheap actually, we can just sort the idAndScore array straightaway and just take the first k elements
        PriorityQueue<Store> minHeap = new PriorityQueue<>((s1, s2) -> s1.score == s2.score ? Integer.compare(s2.id, s1.id) : Long.compare(s1.score, s2.score));
        for (Store store : idAndScore) {
            minHeap.offer(store);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        while (!minHeap.isEmpty()) {
            Store currentStored = minHeap.poll();
            result.add(currentStored.id);
        }
        Collections.reverse(result);
        return result;
    }
    
    private void fillHashSet(String [] feedback, Set<String> feedbackStore) {
        for (String s : feedback) {
            feedbackStore.add(s);
        }
    }
}

class Store {
    int id;
    long score;
    
    public Store(int id, long score) {
        this.id = id;
        this.score = score;
    }
}