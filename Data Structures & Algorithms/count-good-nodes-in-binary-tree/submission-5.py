# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        if not root:
            return 0

        def dfs(root, maxVal):
            if not root:
                return 0

            count = 0
            
            if root.val >= maxVal:
                count += 1

            count += dfs(root.left, max(maxVal, root.val)) + dfs(root.right, max(maxVal, root.val))

            return count
            
        return dfs(root, root.val)