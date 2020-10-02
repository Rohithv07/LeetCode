// using sorting O(nlogn)
class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        char [] s1Array = s1.toCharArray();
        char [] s2Array = s2.toCharArray();
        Arrays.sort(s1Array);
        Arrays.sort(s2Array);
        int lesser = 0;
        int greater = 0;
        for (int i=0; i<s1Array.length; i++) {
            if (s1Array[i] < s2Array[i])
                lesser ++;
            else if (s1Array[i] > s2Array[i])
                greater ++;
            if (lesser > 0 && greater > 0)
                return false;
        }
        return true;
    }
}

// without using sorting O(n)
class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        int [] s1Count = new int [26];
        int [] s2Count = new int [26];
        for (int i=0; i<s1.length(); i++) 
            s1Count[s1.charAt(i)-'a'] += 1;
        for (int i=0; i<s2.length(); i++)
            s2Count[s2.charAt(i)-'a'] += 1;
        int count1 = 0;
        int count2 = 0;
        int greater = 0;
        int lesser = 0;
        for (int i=0; i<26; i++) {
            count1 += s1Count[i];
            count2 += s2Count[i];
            if (count1 > count2)
                greater ++;
            else if (count1 < count2)
                lesser ++;
            if (lesser > 0 && greater > 0)
                return false;
        }
        return true;
    }
}
