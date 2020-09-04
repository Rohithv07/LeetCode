class MyQueue {
    
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();
    private int front;
    /** Initialize your data structure here. */
    public MyQueue() {
        this.stack1 = stack1;
        this.stack2 = stack2;
        this.front = front;
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if (stack1.empty())
            front = x;
        stack1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stack2.isEmpty()) {
        while (!stack1.isEmpty())
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (!stack2.isEmpty())
            return stack2.peek();
        return front;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (stack1.isEmpty() && stack2.isEmpty())
            return true;
        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
