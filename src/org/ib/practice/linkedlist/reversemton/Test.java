package org.ib.practice.linkedlist.reversemton;

import org.ib.practice.linkedlist.ListNode;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(reverseBetween(head, 1, 1));
    }

    public static ListNode reverseBetween(ListNode A, int m, int n) {
        ListNode mPrev = A;
        for (int i = 2; i < m; i++) {
            mPrev = mPrev.next;
        }
        if (m == 1) {
            A = reverseBetweenUtil(mPrev, n - m + 1);
        } else
            mPrev.next = reverseBetweenUtil(mPrev.next, n - m + 1);
        return A;
    }

    private static ListNode reverseBetweenUtil(ListNode head2, int revCount) {
        ListNode p = null, q = head2, r = null;
        while (revCount-- > 0) {
            r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        head2.next = r;
        return p;
    }
}
