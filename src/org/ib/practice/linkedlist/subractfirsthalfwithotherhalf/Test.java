package org.ib.practice.linkedlist.subractfirsthalfwithotherhalf;

import org.ib.practice.linkedlist.ListNode;

public class Test {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        System.out.println(subtract(head));
    }

    public static ListNode subtract(ListNode A) {
        if (A == null || A.next == null) return A;
        ListNode slowPtr = A, fastPtr = A, prevSlowPtr = A;
        while (fastPtr != null && fastPtr.next != null) {
            prevSlowPtr = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        if (fastPtr != null) {
            prevSlowPtr = slowPtr;
            slowPtr = slowPtr.next;
        }
        prevSlowPtr.next = reverse(slowPtr);
        ListNode head1 = A, head2 = prevSlowPtr.next;
        while (head2 != null) {
            head1.val = (head2.val - head1.val);
            head1 = head1.next;
            head2 = head2.next;
        }
        prevSlowPtr.next = reverse(prevSlowPtr.next);
        return A;
    }

    private static ListNode reverse(ListNode slowPtr) {
        ListNode p = null, q = slowPtr, r = null;
        while (q != null) {
            r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        return p;
    }
}
