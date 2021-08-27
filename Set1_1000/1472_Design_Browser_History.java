class BrowserHistory {
    int p = 0;
    List<String> list = new ArrayList<>();
    public BrowserHistory(String homepage) {
        list.add(homepage);
    }
    
    public void visit(String url) {
        list.subList(p+1, list.size()).clear(); // to remove unwanted history
        list.add(url);
        p += 1;
    }
    
    public String back(int steps) {
        p = Math.max(0, p-steps);
        return list.get(p);
            
    }
    
    public String forward(int steps) {
        p = Math.min(list.size()-1, p+steps);
        return list.get(p);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */


// using 2 stacks 

class BrowserHistory {
    Stack<String> back;
    Stack<String> forward;
    public BrowserHistory(String homepage) {
        back = new Stack<>();
        forward = new Stack<>();
        back.push(homepage);
    }
    
    public void visit(String url) {
        back.push(url);
        forward.clear(); // if we go to new page, then we can't move forward, we can only moive backward, so pushed into back stack.
    }
    
    public String back(int steps) {
        int count = 0;
        while (count < steps && back.size() > 1) {
            count += 1;
            forward.push(back.pop()); // if we move backward, then we can after sometime move forward, so fill forward stack.
        }
        return back.peek();
    }
    
    public String forward(int steps) {
        int count = 0;
        while (count < steps && forward.size() > 0) {
            count += 1;
            back.push(forward.pop()); // same idea as that of method back. If we move forward, then after sometime we can move backward. SO we fill the back stack.
        }
        return back.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
