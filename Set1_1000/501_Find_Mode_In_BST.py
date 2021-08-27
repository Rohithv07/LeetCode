"""
My thought process:

Here we need to get the most frequent elemnt and move it to a list and this list have to be finally return.
So I here uses a dfs approach through which we go through each and every elemnt in the tree and add them into a dictionary along with their frequency.

Then I iterate throgh the dictionary once and find out what is the possible maximum frequency that is in our tree. So there can be multiple values with the maximum frequency, so we need to conside them too.

So after obtaining the maximum frequency, I again iterate through the dictionary and add all the keys of the dictionary which is actually the elements in the tree and find out if its frequency is the maximum or not. If its maximum I simply append it into the resultList> So  by doing this I get all the numbers with maximum frequency if there exists multiple such elements.

So thats my thought process. 
but here a follow up is given, to do without extra space but I couldnt get it how.

"""



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findMode(self, root: TreeNode) -> List[int]:
        if root == None:
            return []
        resultList = []
        dictionary = {}
        def dfs(root):
            if root == None:
                return None
            if (root.val in dictionary):
                dictionary[root.val] += 1
            else:
                dictionary[root.val] = 1
            dfs(root.left)
            dfs(root.right)
        dfs(root)
        maximum = 0
        for k, v in dictionary.items():
            if (dictionary[k] > maximum):
                maximum = v
        
        for k, v in dictionary.items():
            if v == maximum:
                resultList.append(k)
        return resultList
            
                
        
