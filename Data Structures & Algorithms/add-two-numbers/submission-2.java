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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode output = new ListNode(0);
        ListNode outP = output;

        int carry = 0;

        while (l1 != null && l2 != null) {
            ListNode newNode = new ListNode(0);
            int sum = l1.val + l2.val + carry;
            newNode.val = sum % 10;
            if (sum > 9) {
                carry = sum / 10;
            } else {
                carry = 0;
            }
            outP.next = newNode;
            outP = outP.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 == null) {
            while (l2 != null) {
                ListNode newNode = new ListNode(0);
                int sum = l2.val + carry;
                newNode.val = sum % 10;
                if (sum > 9) {
                    carry = sum / 10;
                } else {
                    carry = 0;
                }
                outP.next = newNode;
                outP = outP.next;
                l2 = l2.next;
            }
        } else {
            while (l1 != null) {
                ListNode newNode = new ListNode(0);
                int sum = l1.val + carry;
                newNode.val = sum % 10;
                if (sum > 9) {
                    carry = sum / 10;
                } else {
                    carry = 0;
                }
                outP.next = newNode;
                outP = outP.next;
                l1 = l1.next;
            }
        }

        if (carry != 0) {
            outP.next = new ListNode(carry);
        }
        
        return output.next;
    }
}
