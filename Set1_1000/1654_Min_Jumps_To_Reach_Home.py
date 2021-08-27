# 4000 - forward jump cant go beyond this
# and backward jump can go < 0
# {locaton, isBackward}

class Solution:
    def minimumJumps(self, forbidden: List[int], a: int, b: int, x: int) -> int:
        queue = deque([(0, False)])
        minimumJumps = 0
        visited = set()
        visited.add((0, False))
        forbidden = set(forbidden)
        while queue:
            for i in range(len(queue)):
                currentLocation, isBackward = queue.popleft()
                # if we reach our home
                if currentLocation == x:
                    return minimumJumps;
                # the case with jump forward
                nextJump = currentLocation + a
                if nextJump not in forbidden and nextJump < 4000 and (nextJump, False) not in visited:
                    queue.append((nextJump, False))
                    visited.add((nextJump, False))
                # the case with back jump
                if not isBackward:
                    nextJump = currentLocation - b
                    if nextJump not in forbidden and nextJump >= 0 and (nextJump, True) not in visited:
                        queue.append((nextJump, True))
                        visited.add((nextJump, True))
            minimumJumps += 1
        return -1
