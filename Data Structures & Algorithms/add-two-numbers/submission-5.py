# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        output = ListNode()
        cur = output

        carry = 0

        while l1 or l2 or carry:
            v1 = l1.val if l1 else 0
            v2 = l2.val if l2 else 0

            temp = ListNode()
            sums = v1 + v2 + carry

            temp.val = sums % 10
            carry = sums // 10

            cur.next = temp
            cur = cur.next

            l1 = l1.next if l1 else None
            l2 = l2.next if l2 else None

        return output.next