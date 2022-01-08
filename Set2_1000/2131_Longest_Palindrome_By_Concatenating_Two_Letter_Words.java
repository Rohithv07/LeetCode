class Solution {
    public int longestPalindrome(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        // here we have only two possibility
        // 1. the two letter words will be having same letters that is mirror word
        // 2. not a mirror word
        // the mirror word can be placed in the middle and it will add only 2 to our result
        // other words ab, must also have a pair say ba inorder to consider for the result and it will add 4 to our result
        // we will be first checking the existance of the mirror word
        // if the reversed word is already present in the hashmap with a count > 0, the we can say we found a pair
        // we must decrease this words count as we already considered it and update the symmetry based on whether the word is a mirror word or not(we will be reducing)
        // else we can store the non reversed word as a possiblity for our result and increase its count in the map. Here also we will be updating the symmetry based on whether the word is mirror or not.(we will be increasing)
        // finally our answer will be 4 * pairs + 2 if there is any symmetry words we need to consider
        // else answer will be 4 * pairs
        
        Map<String, Integer> map = new HashMap<>();
        int countOfPair = 0;
        int countOfSymmetry = 0;
        for (String word : words) {
            String reverse = new StringBuilder(word).reverse().toString();
            boolean isMirror = false;
            if (word.equals(reverse)) {
                isMirror = true;
            }
            if (map.getOrDefault(reverse, 0) > 0) {
                countOfPair += 1;
                map.put(reverse, map.getOrDefault(reverse, 0) - 1);
                countOfSymmetry -= (isMirror ? 1 : 0);
            }
            else {
                map.put(word, map.getOrDefault(word, 0) + 1);
                countOfSymmetry += (isMirror ? 1 : 0);
            }
        }
        return 4 * countOfPair + (countOfSymmetry > 0 ? 2 : 0);
    }
}