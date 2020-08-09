"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

class Solution:
    def connect(self, root: 'Node') -> 'Node':
        """
        We need to know the root whether has the right children.
        Then we just connect the left children to the right children.
        If the right children need to connect to another node, the condition is that its root.next is not empty and the             root.next has left children.
        Then we can connect them, otherwise just need to make the right children's next to null.
        I think it's a straightforward way.
        """
        
        if root is None:
            return None
        if root.left is not None:
            root.left.next = root.right
            
        if root.right != None and root.next != None and root.left.next != None:
            root.right.next = root.next.left
            
        self.connect(root.left)
        self.connect(root.right)
        
        return root
        
