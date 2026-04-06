# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        if head is None or head.next is None:
            return False

        fast = head
        slow = head

        while fast is not None:
            if fast.next is None or fast.next.next is None:
                return False

            fast = fast.next.next
            slow = slow.next

            if (fast == slow):
                return True
        
        return False
            
        