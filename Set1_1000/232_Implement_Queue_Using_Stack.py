class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.first = []
        self.last = []

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        length = len(self.first)
        for i in range(length):
            self.last.append(self.first.pop())
        self.last.append(x)
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        length = len(self.last)
        for i in range(length):
            self.first.append(self.last.pop())
        return self.first.pop()

    def peek(self) -> int:
        """
        Get the front element.
        """
        if (len(self.last) > 0):
            return self.last[0]
        return self.first[len(self.first)-1]
        

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if len(self.first) == 0 and len(self.last) == 0:
            return True
        return False


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
