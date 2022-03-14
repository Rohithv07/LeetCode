class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String [] values = path.split("/");
        for (String val : values) {
            if (val.equals("..") && !stack.isEmpty()) {
                stack.pop();
            }
            else if (!val.equals(".") && !val.equals("..") && !val.equals("")) {
                stack.push(val);
            }
        }
        return "/" + String.join("/", stack);
    }
}

// using array deque

class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String [] split = path.split("/");
        Deque<String> deque = new ArrayDeque<>();
        for (String s : split) {
            if (s.length() == 0 || s.equals(".")) {
                continue;
            }
            if (s.equals("..")) {
                deque.pollFirst();
            }
            else {
                deque.offerFirst(s);
            }
        }
        while (!deque.isEmpty()) {
            sb.append("/").append(deque.pollLast());
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
