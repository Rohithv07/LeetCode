class Solution {
    public boolean isHappy(int n) {
        // using hashset
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            if (set.contains(n))
                return false;
            set.add(n);
            n = findSquare(n);
        }
        return true;
        
        
        // using linked list cycle detection algorithm

        // int slow = n;
        // int fast = n;
        // do {
        //     slow = findSquare(slow);
        //     fast = findSquare(fast);
        //     if (fast == 1)
        //         return true;
        //     fast = findSquare(fast);
        //     if (fast == 1)
        //         return true;
        // }while (slow != fast);
        // return false;
    }
    
    public int findSquare(int n) {
        int square = 0;
        while (n > 0) {
            int rem = n % 10;
            square += rem * rem;
            n /= 10;
        }
        return square;
    }
}
