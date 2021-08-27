class Solution {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        if (students == null || students.length == 0 || mentors == null || mentors.length == 0)
            return 0;
        int row = students.length;
        int col = students[0].length;
        boolean [] visited = new boolean[row];
        int [] max = new int [1];
        backtrack(students, mentors, 0, 0, visited, max);
        return max[0];
    }
    
    public void backtrack(int [][] students, int [][] mentors, int currentPosition, int currentScore,boolean [] visited, int [] max) {
        if (currentPosition >= students.length) {
            max[0] = Math.max(max[0], currentScore);
            return;
        }
        for (int i=0; i<mentors.length; i++) {
            if (!visited[i]) {
                // make a decision
                visited[i] = true;
                // backtrack
                backtrack(students, mentors, currentPosition + 1, currentScore + findMentorStudentScore(students[currentPosition], mentors[i]), visited, max);
                // undo the decision
                visited[i] = false;
            }
        }
    }
    
    public int findMentorStudentScore(int [] student, int [] mentor) {
        int score = 0;
        for (int i=0; i<student.length; i++) {
            if (student[i] == mentor[i])
                score += 1;
        }
        return score;
    }
}