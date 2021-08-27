class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if grid is None or len(grid) == 0:
            return 0
        numberOfIslands = 0
        for i in range(0, len(grid)):
            for j in range(0, len(grid[0])):
                if grid[i][j] == '1':
                    numberOfIslands += self.dfsHelper(grid, i, j)
        return numberOfIslands
    def dfsHelper(self, grid, i, j):
            if i < 0 or j < 0 or i >= len(grid) or j >= len(grid[0]) or grid[i][j] == '0':
                return 0
            grid[i][j] = '0'
            self.dfsHelper(grid, i+1, j)
            self.dfsHelper(grid, i-1, j)
            self.dfsHelper(grid, i, j+1)
            self.dfsHelper(grid, i, j-1)
            return 1
