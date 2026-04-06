# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        if head.next == None or head.next.next == None:
            return None

        slow = head
        fast = head
        
        while fast != None and fast.next != None:
            slow = slow.next
            fast = fast.next.next
        
        half = slow.next
        slow.next = None

        curr = half
        prev = None

        while curr != None:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        
        # First half is head
        # Second half is prev (reversed second half)

        firstHalf = head
        secondHalf = prev

        while secondHalf != None:
            firstNext = firstHalf.next
            secondNext = secondHalf.next

            firstHalf.next = secondHalf
            secondHalf.next = firstNext
            firstHalf = firstNext
            secondHalf = secondNext

        

        
        
        
        