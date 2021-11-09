/*
this question is just finding the shortest path to make String s1 to String s2. But the trickier part here is to get the neighbouring string for s1 after swapping 2 letters as all the combination taking into consideration will result in TLE.

We set all possible strings that can be formed by swapping the positions of two letters in A' one time as neighbours of A', however, only those can make A and B differ less are meaningful neighbours.
That is, if A'[i] != B[i] but A'[j] == B[i], the string formed by swap(A, i, j) 
is a meaningful neighbour of A'. Please note that we just need to swap the 
first pair (A'[i], A'[j]) we meet because the order of swap doesn't matter.

*/


class Solution {
    public int kSimilarity(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return -1;
        }
        if (s1.equals(s2)) {
            return 0;
        }
        int length1 = s1.length();
        int length2 = s2.length();
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(s1);
        visited.add(s1);
        int k = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                String current = queue.poll();
                if (current.equals(s2)) {
                    return k;
                }
                for (String neighbour : findTheNeighbour(current, s2)) {
                    if (!visited.contains(neighbour)) {
                        visited.add(neighbour);
                        queue.offer(neighbour);
                    }
                }
            }
            k++;
        }
        return k;
    }
    
    private List<String> findTheNeighbour(String s1, String s2) {
        List<String> neighbours = new ArrayList<>();
        char [] s = s1.toCharArray();
        int i = 0;
        for (; i<s1.length(); i++) {
            if (s[i] != s2.charAt(i)) {
                break;
            }
        }
        for (int j=i+1; j<s1.length(); j++) {
            if (s[j] == s2.charAt(i)) {
                swap(s, i, j);
                neighbours.add(new String(s));
                swap(s, i, j);
            }
        }
        return neighbours;
    }
    
    private void swap(char [] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}