class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        for (int i=1; i<=9; i++) 
            helperFunction(result, low, high, 0, i);
        Collections.sort(result);
        return result;
    }
    public void helperFunction(List<Integer> result, int low, int high, int answer, int i) {
        if (answer > high)
            return;
        if (answer >= low)
            result.add(answer);
        if (i > 9)
            return;
        helperFunction(result, low, high, answer*10+i, i+1);
    }
}
