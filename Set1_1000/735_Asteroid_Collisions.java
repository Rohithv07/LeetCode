// here we need to use stack and we can easily check whether the asteroids are moving in opposite direction or not + whether they are completely exploded
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids.length == 1)
            return asteroids;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < asteroids.length) {    // O(lengthArray)
            // if positive push to the stack
            if (asteroids[i] > 0) {
                stack.push(asteroids[i]);
            }
            // otherwise we need to consider with the negative numbers and the equality
            else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroids[i])) { // O(stackSize)
                    // now we have collision and we can pop the element
                    stack.pop();
                }
                // we already have a negative number and we can still push the element
                if (stack.isEmpty() || stack.peek() < 0)
                    stack.add(asteroids[i]);
                // if we have same values, then completely gets destroyed
                else if (stack.peek() == Math.abs(asteroids[i]))
                    stack.pop();
            }
            i += 1;
        }
        int [] finalResult = new int [stack.size()];
        // since stack elements are in reverse order(LastInFirstOut), then we need to add elements to the back
        for (int j=stack.size()-1; j>=0; j--)
            finalResult[j] = stack.pop();
        return finalResult;
    }
}

// O(arrayLength * stacksize(CONSTANT)) = O(arrayLength)
