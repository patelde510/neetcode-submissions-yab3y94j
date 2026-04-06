/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // Store second half to reverse before we split
        ListNode second = slow.next;
        // Splits into two lists by ending it with null.
        slow.next = null;
        ListNode prev = null;
        while (second != null) {
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }

        ListNode newHead = head;
        second = prev;
        while (prev != null) {
            ListNode temp1 = newHead.next;
            ListNode temp2 = prev.next;
            newHead.next = prev;
            prev.next = temp1;
            newHead = temp1;
            prev = temp2;
        }
    }
}
