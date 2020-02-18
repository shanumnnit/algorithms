package org.ib.practice.heaps.mergeksortedlists;

import org.ib.practice.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(10);
        l1.next.next = new ListNode(20);
        ListNode l2 = new ListNode(4);
        l2.next = new ListNode(11);
        l2.next.next = new ListNode(21);
        ListNode l3 = new ListNode(3);
        l3.next = new ListNode(8);
//        l3.next.next = new ListNode(9);
        print(mergeKLists(new ArrayList<>(Arrays.asList(l1, l2, l3))));
    }

    public static void print(ListNode l) {
        while (l != null) {
            System.out.print(l.val + " -> ");
            l = l.next;
        }
    }

    public static ListNode mergeKLists(ArrayList<ListNode> a) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(l -> l.val));
        for (ListNode l : a)
            pq.add(l);
        ListNode resHead = null;
        ListNode resTail = null;
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            if (resHead == null) {
                resHead = minNode;
                resTail = minNode;
                if (minNode.next != null)
                    pq.add(minNode.next);
                continue;
            }
            resTail.next = minNode;
            resTail = resTail.next;
            if (minNode.next != null)
                pq.add(minNode.next);
        }
        return resHead;
    }
}
