/* My thought process:
So at first I started with a cycle detection in a graph and I tried to convert the grid into a graph using the arraylist and linking each element as normal graph initialisation. Then I do the normal dfs cycle detection with recursionStack and visited stack. But somewhere I didn't went into deep, I got stuck and I was not getting the correct answer, so I just looked on to the discuss and find a more understandable code and I started thinking that way.

Here we need to keep track whether we visited each of the element in the grid, so a 2d boolean array visited is created and when we visit it, we change the correspoding value to true.
Then here the return type is boolean so a boolean check variable is used to know whether we have a cycle or not.

Now we travrese through the grid and check whether there is no loop and we didnt visited that cell before, if the condition holds true, we go with our dfs function. Here a extra value 0 is used which is taken as a default direction and in the question it is told that we can go in all 4 directions. So what I mean here is inside the dfs function I make use of a direction variable to know which direction or to which direction we can go. 1 mean up, 2 means down, 3 means left, 4 mean down.
            Visually
               
                        1                                                   
                    3       4
                        2
This is what I actually meant by taking the direction

Now moving on with our function

dfsFunctiom() 
-> Here we check whether we detected a cycle or not, if it is like that we can exit from the function by just using an empty return statement.
-> We check for the base conditions which is quite common.
-> Then if we donot visit a particular cell then,
        - We make that cell visited and check for the direction,
            if direction != 1, then just take the opposite of 1, that is 2, and call the dfsFunction with direction = 2
            if direction != 2, then just take opposite of 2, and call function with direction = 1
            if direction != 3, then just take opposite of 2, and call function with direction = 4
            if direction != 4, then just take opposite of 2, and call function with direction = 3
-> But if we visited the cell already, then just make check variable to true.

This is what I come up with this process.
*/

class Solution {
    boolean check;
    public boolean containsCycle(char[][] grid) {
        int row = grid.length; 
        int column = grid[0].length;
        boolean [][] visited = new boolean[row][column];
        for (int i=0; i<row; i++) {
            for (int j=0; j<column; j++) {
                if (!check && !visited[i][j]) {
                    dfsCycleDetect(grid, i, j, visited, grid[i][j], 0); // 0 specifies the direction 4 directions eg:
                  /*      
                        1                                                   
                    3       4
                        2
                        */
                }       
                
            }
        }
        return check;
    }
    public void dfsCycleDetect(char [][] grid, int i, int j, boolean [][] visited, char c, int direction) {
        if (check == true)
            return;
        if (i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]!=c)
            return;
        if (!visited[i][j]) {
            visited[i][j] = true;
            if (direction != 1) 
                dfsCycleDetect(grid, i+1, j, visited, c, 2);
            if (direction != 2)
                dfsCycleDetect(grid, i-1, j, visited, c, 1);
            if (direction != 3)
                dfsCycleDetect(grid, i, j+1, visited, c , 4);
            if (direction != 4)
                dfsCycleDetect(grid, i, j-1, visited, c, 3);
        }
        else 
            check = true;
    }
}
