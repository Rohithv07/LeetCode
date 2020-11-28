class FrontMiddleBackQueue {
    LinkedList<Integer> requiredQueue;
    public FrontMiddleBackQueue() {
        requiredQueue = new LinkedList<>();
    }
    
    public void pushFront(int val) {
        requiredQueue.addFirst(val);
    }
    
    public void pushMiddle(int val) {
        requiredQueue.add(requiredQueue.size() / 2, val);
    }
    
    public void pushBack(int val) {
        requiredQueue.addLast(val);
    }
    
    public int popFront() {
        return !requiredQueue.isEmpty() ? requiredQueue.removeFirst() : -1;
    }
    
    public int popMiddle() {
        return !requiredQueue.isEmpty() ? requiredQueue.remove((requiredQueue.size() - 1) / 2) : -1;
    }
    
    public int popBack() {
        return !requiredQueue.isEmpty() ? requiredQueue.removeLast() : -1;
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */
