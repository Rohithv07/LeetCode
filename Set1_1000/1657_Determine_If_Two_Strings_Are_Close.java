/*
My thought process:
Here I found the frequency of each of the character from word1 and word2
Then I go through each of the count from the count arrays say count1 and count2 and we continue only if both count1[i] and count2[i]
is 0.
If only count1[i] or count2[i] = 0 means there is a letter that is present in one of the word but not in the other
For example : word1 = aab word2 = aac
Now our count array will be count1 = [2, 1, 0, ...] and count2 = [2, 0, 1, ..]. 
So if we look at it, we can understand that count of b = 1 in count1 but = 0, in count2. So when this case arises, we can make the string close

Now we sort the two count arrays and its complexity will be 26log(26) = constant
Now we check for each of the index, the values of the count arrays are equal. If there is any particular position where it is not equal, then we return false
Other wise return true;

*/

class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;
        int length = word1.length();
        int [] count1 = new int [26];
        int [] count2 = new int [26];
        for (char ch : word1.toCharArray())
            count1[ch-'a'] += 1;
        for (char ch: word2.toCharArray())
            count2[ch-'a'] += 1;
        // check if there is any discrepancy in the minimum and the maximum vakue
        for (int i=0; i<26; i++) {
            if (count1[i] == count2[i])
                continue;
            if (count1[i] == 0 || count2[i] == 0)
               return false;
        }
        Arrays.sort(count1); // since the array size is 26 and it will not change, here the sorting is 26log26
        Arrays.sort(count2);
        for (int i=0; i<26; i++)
            if (count1[i] != count2[i])
                return false;
        return true;
    }
}
