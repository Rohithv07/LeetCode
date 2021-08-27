class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        if len(s) == 0:
            return 0
        length = 0
        x = s.strip()
        for i in range(len(x)):
            if x[i] == ' ':
                length = 0
            else:
                length += 1
        return length

"""
Thought process:
Here we need to find the length of the last word from the given word separated by space. Here sometime there can be extra spaces given in the last too. So we cant't just split the word by spaces and return len(lastWord).
So first of all let us get rid of these spaces by trimming or in python strip.
After stripping we iterate through the string.
Whenever there is a space, it is an indication that we are not at the very end, there is still words. So wheneevr we see space, we set the length into 0, whenever we donot see a space, we increment our length variable.

Finally just return the length and thats our answer.
"""
