/* My Thought Process
Before looking into the hint, when I saw that the names obtained must be unique, the first thing that came to my mind was using a HashMap. 
So here we use a hash map inorder to keep track of the occurance of the names and to decide whether it is unique and how we have to name the file.

-> SO we traverse through the string array,
-> Lets store the current name to a variable say current.
-> So if the current is not in the map, then we are cool, we just have the same number becuase its the lowest number unique name.
-> But when we again see the same name that we seen before, there occurs a duplicate and we have to check while map contaisn duplicate name, then
            - We get the current value of that key.
            - So now we have to increment the counter of that particular word.
            - Now we put that name into the map along with the updated count to say that it happends say n number of times.
            - Now I here use a string builder to create a new string with the current name, (, the count,).
            - Now the name from the String array will be updated with the new name.
Here insted of StringBuilder, we can make use of just + operator for concatenation, but I found this opportunity to get more familiar with the StrinBuilder I used it. Thats all.
*/



class Solution {
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<names.length; i++) {
            String current = names[i];
            while (map.containsKey(current)) {
                int count = map.get(names[i]);
                count += 1;
                map.put(names[i], count);
                StringBuilder sb = new StringBuilder();
                sb.append(names[i]);
                sb.append("(");
                sb.append(count);
                sb.append(")");
                current = sb.toString();
            }
            map.put(current, 0);
            names[i] = current;
        }
        return names;
    }
}
