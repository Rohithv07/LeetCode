/*
My thought process:

The main thing we need to check is the length of the string to be larger than k, else we cant form k palindromes.
Next thing is if any of the character from the string have a count > k, then we cant form k palindrome else we can form k palindrome. For eg:
            For any string with 0 odd character count , we can form k no. of palindrome strings for sure with k<=n
(This is why k<=n)

eg
aabb, k=1| abba
aabb, k=2 | aa, bb
aabb, k=3 | a, a, bb
aabb, k=4 | a, a, b, b

For any string with odd character count <=k , we can always form k palindrome string for sure with k<=n
eg2
aabbc, k=1 | aacbb
aabbc, k=2 | aca, bb
aabbc, k=3 | a,a, bcb
aabbc, k=4 | a, a, c ,bb
aabbc, k=5 | a, a, c, b, b

eg3
aabc, k=1 | N/A
aabc, k=2 | aba, c
aabc, k=3 | aa, b, c
aabc, k=4 | a, a, b, c

This exampe is probided in the discuss section.

SO I here uses a hashmap to store the count of each word and checks how many character have count < k or count >k.
if oddcount < k, return false, else return true.

Thats the problem.

*/

class Solution {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k)
            return false;
        // if no of characters that is odd and is < k, then we cant, say false
        // else say true
        Map<Character, Integer> map = new HashMap<>();
        for (char ch: s.toCharArray()) {
            if (map.containsKey(ch))
                map.replace(ch, map.get(ch)+1);
            else
                map.put(ch, 1);
        }
        int oddCount = 0;
        for (Map.Entry e : map.entrySet()) {
            int value = (int)e.getValue();
            if (value % 2 != 0)
                oddCount += 1;
        }
        if (oddCount > k)
            return false;
        return true;
    }
}
