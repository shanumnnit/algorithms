package org.ib.practice.linkedlist.checkpalindrome;


import org.ib.practice.linkedlist.ListNode;

public class Test {


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(lPalin(head));
    }

    public static int lPalin(ListNode A) {
        ListNode slowPtr = A, fastPtr = A;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        ListNode head2 = null, mid = null;
        if (fastPtr != null) {
            head2 = slowPtr.next;
            mid = slowPtr;
        } else
            head2 = slowPtr;
        head2 = reverseList(head2);
        for (ListNode temp1 = A, temp2 = head2; temp2 != null; temp1 = temp1.next, temp2 = temp2.next) {
            if (temp1.val != temp2.val)
                return 0;
        }
        return 1;
    }

    private static ListNode reverseList(ListNode head2) {
        if (head2 == null || head2.next == null) return head2;
        ListNode p = null, q = head2, r = null;
        while (q != null) {
            r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        return p;

    }
}
