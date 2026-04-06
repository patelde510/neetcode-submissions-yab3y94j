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
        Map<Node, Node> oldToCopy = new HashMap<>();
        oldToCopy.put(null, null);

        Node cur = head;
        while (cur != null) {
            Node tempCopy = new Node(cur.val);
            oldToCopy.put(cur, tempCopy);
            cur = cur.next;
        }

        cur = head;
        while (cur!= null) {
            Node tempCopy = oldToCopy.get(cur);
            tempCopy.next = oldToCopy.get(cur.next);
            tempCopy.random = oldToCopy.get(cur.random);
            cur = cur.next;
        }

        return oldToCopy.get(head);
    }
}
