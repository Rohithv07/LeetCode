class Solution {
    public double average(int[] salary) {
        int max = Arrays.stream(salary).max().getAsInt();
        int min = Arrays.stream(salary).min().getAsInt();
        double sum = 0;
        for (int i=0; i<salary.length; i++) {
            sum += salary[i];
        }
        return (sum - (max + min)) / (salary.length-2);
    }
}
