# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        sz = 0
        sNode = head

        while sNode:
            sz += 1
            sNode = sNode.next

        remove = sz - n
        dummy = ListNode(0, head)
        
        cur = dummy
        for _ in range(remove):
            cur = cur.next

        cur.next = cur.next.next

        return dummy.next