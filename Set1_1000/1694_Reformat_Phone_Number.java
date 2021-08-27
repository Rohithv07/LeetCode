class Solution {
    public String reformatNumber(String number) {
        if (number.length() == 2)
            return number;
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        // put all the digits to the queue
        for (char ch: number.toCharArray()) {
            if (Character.isDigit(ch))
                queue.offer(ch);
        }
        while (queue.size() > 4) {
            sb.append(queue.poll()).append(queue.poll()).append(queue.poll()).append("-");
        }
        if (queue.size() == 4) // now we need 2 number and -
            sb.append(queue.poll()).append(queue.poll()).append("-");
        while (!queue.isEmpty()) // while there is still elements inside the queue
            sb.append(queue.poll());
        return sb.toString();
    }
}
