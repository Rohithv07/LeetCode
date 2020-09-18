/* My thought process
So we are given a path with the different directions and the type is a String. SO when we see each of the directions we increase by 1 unit.
If North, we would move up in the y cordinate, so increase y by 1
If South, we would move down in the y cordinate, so decrease y by 1
If East, we would move right in the x coordinate, so increase x by 1
If West, we would move left in the x coordinates, so decrease x by 1.

So if we reach the same path or crosses any of the previously visited path, we need to return true else we return false saying we donot have a cross on the previous node.

So we can use a hash set to deal with this duplicate> Here after each move we add our current positions into the hashset so that if we again visit the point again, then we can track it by checking inside the hashset. If we found the path in the set, then we can conclude that we crossed the path previously visited adn we can return true. Else just add the path into the set for future checking.

If we successfylly gets out of the travresing odf the string, then we conclude there is no crossing, so return false. Thats it.

*/

class Solution {
    public boolean isPathCrossing(String path) {
        int x = 0;
        int y = 0;
        Set<String> set = new HashSet<>();
        String initial = "(0,0)";
        set.add(initial);
        for (char ch: path.toCharArray()) {
            if (ch == 'N')
                y += 1;
            else if (ch == 'S')
                y -= 1;
            else if (ch == 'W')
                x -= 1;
            else 
                x += 1;
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(x);
        sb.append(",");
        sb.append(y);
        sb.append(")");
        String currentPath = sb.toString();
        if (set.contains(currentPath))
            return true;
        else 
            set.add(currentPath);
        }
        return false;
    }
}
