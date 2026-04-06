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
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode output = new ListNode(0);
        ListNode outP = output;

        int carry = 0;

        while (c1 != null && c2 != null) {
            ListNode newNode = new ListNode(0);
            int sum = c1.val + c2.val + carry;
            newNode.val = sum % 10;
            if (sum > 9) {
                carry = sum / 10;
            } else {
                carry = 0;
            }
            outP.next = newNode;
            outP = outP.next;
            c1 = c1.next;
            c2 = c2.next;
        }

        if (c1 == null) {
            while (c2 != null) {
                ListNode newNode = new ListNode(0);
                int sum = c2.val + carry;
                newNode.val = sum % 10;
                if (sum > 9) {
                    carry = sum / 10;
                } else {
                    carry = 0;
                }
                outP.next = newNode;
                outP = outP.next;
                c2 = c2.next;
            }
        } else {
            while (c1 != null) {
                ListNode newNode = new ListNode(0);
                int sum = c1.val + carry;
                newNode.val = sum % 10;
                if (sum > 9) {
                    carry = sum / 10;
                } else {
                    carry = 0;
                }
                outP.next = newNode;
                outP = outP.next;
                c1 = c1.next;
            }
        }

        if (carry != 0) {
            outP.next = new ListNode(carry);
        }
        
        return output.next;
    }
}
