class CustomStack {
    private int maxSize;
    private List<Integer> stack = new ArrayList<>();
    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
    }
    
    public void push(int x) {
        if (stack.size() < maxSize)
            stack.add(x);
    }
    
    public int pop() {
        if (stack.isEmpty())
            return -1;
        return stack.remove(stack.size()-1);
    }
    
    public void increment(int k, int val) {
        for (int i=0; i<Math.min(k, stack.size()); i++)
            stack.set(i, val + stack.get(i));
    
    }
}





// another solution
    private int maxSize;
    private Stack<Integer> stack = new Stack<>();
    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
    }
    public void push(int x) {
        if (stack.size() < maxSize)
            stack.push(x);
    }
    public int pop() {
        if (stack.isEmpty())
            return -1;
        return stack.pop();
    }
    public void increment(int k, int val) {
        Stack<Integer> tempStack = new Stack<>();
        int threshold = stack.size() - k;
        while (!stack.isEmpty()) {
            if (threshold > 0) {
                threshold --;
                tempStack.push(stack.pop());
            }
            else
                tempStack.push(val + stack.pop());
        }
        while (!tempStack.isEmpty())
            stack.push(tempStack.pop());
    }
}
    

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
