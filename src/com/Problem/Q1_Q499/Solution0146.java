package com.Problem.Q1_Q499;

import java.util.*;

public class Solution0146 {
    class HashList {
        HashList next;
        HashList pre;
        int key;
        int value;

        public HashList() {
        }

        public HashList(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int size = 0;
    HashList head;
    HashList tail;
    int cur = 0;
    HashMap<Integer, HashList> map = new HashMap<>();
    List<Integer> queue = new LinkedList<>();

    public Solution0146(int capacity) {
        size = capacity;
        head = new HashList();
        tail = new HashList();
        head.next = tail;
        tail.pre = head;
    }

    public void addtoHeadnode(HashList node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    public void removeNode(HashList node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void movetohead(HashList node) {
        removeNode(node);
        addtoHeadnode(node);
    }

    public HashList removetail() {
        HashList node = tail.pre;
        removeNode(node);
        return node;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            movetohead(map.get(key));
            return map.get(key).value;
        }
    }

    public void put(int key, int value) {
        HashList node = map.get(key);
        if (node == null) {
            if (cur < size) {
                HashList newnode = new HashList(key, value);
                addtoHeadnode(newnode);
                map.put(key, newnode);
                cur++;
            } else {
                HashList newnode = new HashList(key, value);
                HashList removenode = removetail();
                map.remove(removenode.key);
                addtoHeadnode(newnode);
                map.put(key, newnode);
            }
        } else {
            node.value = value;
            movetohead(node);
        }
    }

    public static void main(String[] args) {
        Solution0146 s = new Solution0146(2);
        System.out.println(s.get(2));
        s.put(1, 1);
        s.put(2, 2);
        System.out.println(s.get(1));
        s.put(3, 3);
        System.out.println(s.get(2));
        s.put(4, 4);
        System.out.println(s.get(1));
        System.out.println(s.get(3));
        System.out.println(s.get(4));
    }
}
