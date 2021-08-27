/*
We start with left being the first word.

findRight: Then we greedily try to go as far right as possible until we fill our current line.

Then we justify one line at a time.

justify: In all cases we pad the right side with spaces until we reach max width for the line;

If it's one word then it is easy, the result is just that word.
If it's the last line then the result is all words separated by a single space.
Otherwise we calculate the size of each space evenly and if there is a remainder we distribute an extra space until it is gone.
*/

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;
        while (index < words.length) {
            int count = words[index].length();
            int last = index + 1;
            while (last < words.length) {
                if (words[last].length() + count + 1 > maxWidth) {
                    break;
                }
                // + 1 for the space if its a best fit
                count += 1 + words[last].length();
                last += 1;
            }
            StringBuilder builder = new StringBuilder();
            builder.append(words[index]);
            int diff = last - index - 1;
            // if last line or number of words in the line is left justified
            if (last == words.length || diff == 0) {
                for (int i=index+1; i<last; i++) {
                    builder.append(" ");
                    builder.append(words[i]);
                }
                for (int i=builder.length(); i<maxWidth; i++) {
                    builder.append(" ");
                }
            }
            else {
                // middle justified
                int spaces = (maxWidth - count) / diff;
                int r = (maxWidth - count) % diff;
                for (int i=index+1; i<last; i++) {
                    for (int k=spaces; k>0; k--) {
                        builder.append(" ");
                    }
                    if (r > 0) {
                        builder.append(" ");
                        r--;
                    }
                    builder.append(" ");
                    builder.append(words[i]);
                }
            }
            result.add(builder.toString());
            index = last;
        }
        return result;
    }
}
