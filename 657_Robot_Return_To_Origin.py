Python : No extra space
class Solution:
    def judgeCircle(self, moves: str) -> bool:
        if len(moves) == 0:
            return True
        x , y = 0, 0
        for element in moves:
            if element == "U":
                x += 1
            elif element == "D":
                x -= 1
            elif element == "R":
                y += 1
            elif element == "L":
                y -= 1
        if x == 0 and y == 0:
            return True
        return False


Python : Extra space
class Solution:
    def judgeCircle(self, moves: str) -> bool:
        if len(moves) == 0:
            return True
        origin = [0, 0]
        for element in moves:
            if element == "U":
                origin[0] += 1
            elif element == "D":
                origin[0] -= 1
            elif element == "R":
                origin[1] += 1
            elif element == "L":
                origin[1] -= 1
        if origin[0] == 0 and origin[1] == 0:
            return True
        return False
