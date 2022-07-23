package com.Problem.Q1_Q499;

// Definition for a Node1.
class Node1 {
    int val;
    Node1 next;
    Node1 random;

    public Node1(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution0138 {
    public Node1 copyRandomList(Node1 head) {
        if (head == null) {
            return null;
        }
        Node1 p = head;
        while (head != null) {
            Node1 newNode1 = new Node1(head.val);
            newNode1.next = head.next;
            head.next = newNode1;
            head = head.next.next;
        }
        head = p;
        while (head != null) {
            if (head.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
        head = p;
        Node1 dummy = new Node1(-1);
        Node1 cur = dummy;
        while (head != null) {
            cur.next = head.next;
            cur = cur.next;
            head.next = cur.next;
            head = head.next;
        }
        return dummy.next;
    }
}
