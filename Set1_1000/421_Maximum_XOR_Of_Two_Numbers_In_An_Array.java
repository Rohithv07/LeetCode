class Solution {
    
    private TrieNode root = new TrieNode();
    
    public void insert(int number) {
        TrieNode node = root;
        for (int i=31; i>=0; i--) {
            // get ith bit
            int currentBit = (number >> i) & 1;
            if (node.array[currentBit] == null) {
                node.array[currentBit] = new TrieNode();
            }
            node = node.array[currentBit];
        }
    }
    
    public int findMaximumXOR(int[] nums) {
        int length = nums.length;
        int maxXor = Integer.MIN_VALUE;
        for (int number : nums) {
            insert(number);
        }
        for (int number : nums) {
            TrieNode node = root;
            int currentXor = 0;
            for (int i=31; i>=0; i--) {
                int currentBit = (number >> i) & 1;
                if (node.array[currentBit ^ 1] != null) {
                    currentXor += (1 << i);
                    node = node.array[currentBit ^ 1];
                }
                else {
                    node = node.array[currentBit];
                }
            }
            maxXor = Math.max(maxXor, currentXor);
        }
        return maxXor;
    }
}

class TrieNode {
    TrieNode [] array;
    public TrieNode() {
        array = new TrieNode[2];
    }
}
