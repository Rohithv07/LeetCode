class FreqStack {

    private Map<Integer, Integer> count = new HashMap<>();
    private Map<Integer, Stack<Integer>> map = new HashMap<>();
    int maximumFreq = 0;
    
    public FreqStack() {
        
    }
    
    public void push(int x) {
        int currentCount = count.getOrDefault(x, 0) + 1;
        count.put(x, currentCount);
        maximumFreq = Math.max(maximumFreq, currentCount);
        if (!map.containsKey(currentCount))
            map.put(currentCount, new Stack<>());
        map.get(currentCount).add(x);
    }
    
    public int pop() {
        int current = map.get(maximumFreq).pop();
        count.put(current, maximumFreq - 1);
        if (map.get(maximumFreq).size() == 0)
            maximumFreq -= 1;
        return current;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */
