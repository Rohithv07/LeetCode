class Solution:
    def countStudents(self, students: List[int], sandwiches: List[int]) -> int:
        queue = collections.deque(students)
        for sandwich in sandwiches:
            if sandwich in queue:
                while queue[0] != sandwich:
                    front = queue.popleft()
                    queue.append(front)
                queue.popleft()
            else:
                return len(queue)
        return 0
            
