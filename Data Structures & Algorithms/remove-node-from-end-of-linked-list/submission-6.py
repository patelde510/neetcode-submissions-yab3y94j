# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        listLen = 0
        res = head
        prev = None
        
        while (head != None):
            listLen += 1
            head = head.next

        if listLen == 1:
            return None
        

        head = res
        if listLen == n:
            return head.next
        removeIndex = listLen - n

        for i in range(removeIndex):
            prev = head
            head = head.next
        


        prev.next = head.next
        print(listLen)
        return res