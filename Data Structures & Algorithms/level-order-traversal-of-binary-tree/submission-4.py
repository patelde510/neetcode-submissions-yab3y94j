# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        res = []

        if not root:
            return res

        q = deque()
        q.append(root)

        while q:
            curLevel = []

            size = len(q)

            for _ in range(size):
                cur = q.popleft()
                curLevel.append(cur.val)
                if cur.left:
                    q.append(cur.left)
                if cur.right:
                    q.append(cur.right)
            res.append(curLevel)

        return res
