class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        // int count = 0;
        // Set<Character> set = new HashSet<>();
        // for (char ch : jewels.toCharArray()) {
        //     set.add(ch);
        // }
        // for (char ch : stones.toCharArray()) {
        //     if (set.contains(ch))
        //         count += 1;
        // }
        // return count;
        int result = 0;
        int [] count = new int [128];
        for (char ch : stones.toCharArray()) {
            count[ch] += 1;
        }
        for (char ch : jewels.toCharArray()) {
            result += count[ch];
        }
        return result;
    }
}



class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        boolean [] isPresent = new boolean [256];
        int countJewels = 0;
        for (char ch : jewels.toCharArray()) {
            isPresent[ch] = true;
        }
        for (char ch : stones.toCharArray()) {
            if (isPresent[ch]) {
                countJewels +=1;
            }
        }
        return countJewels;
    }
}
