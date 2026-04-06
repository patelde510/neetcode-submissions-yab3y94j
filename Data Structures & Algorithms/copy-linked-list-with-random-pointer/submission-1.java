/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> oldToNew = new HashMap<>();
        oldToNew.put(null, null);

        Node cur = head;

        while (cur != null) {
            Node temp = new Node(cur.val);
            oldToNew.put(cur, temp);
            cur = cur.next;
        }

        cur = head;

        while (cur != null) {
            Node temp = oldToNew.get(cur);
            temp.next = oldToNew.get(cur.next);
            temp.random = oldToNew.get(cur.random);
            cur = cur.next;
        }

        return oldToNew.get(head);

    }
}
