package org.ib.practice.linkedlist.insertionsort;

import org.ib.practice.linkedlist.ListNode;

public class Test {
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(1);
        System.out.println(insertionSortList(head));
    }

    public static ListNode insertionSortList(ListNode A) {
        if (A == null || A.next == null)
            return A;
        ListNode prev, curr = A.next, currPrev = A, currNext;
        while (curr != null) {
            prev = A;
            currNext = curr.next;
            while (prev != null && prev.next != curr && prev.next.val < curr.val)
                prev = prev.next;

            //take curr out of list
            currPrev.next = null;
            if (curr.next != null)
                currPrev.next = curr.next;

            //insert curr in sorted left sublist
            if (curr.val < A.val) {
                curr.next = A;
                A = curr;
            } else {
                ListNode tempNext = prev.next;
                prev.next = curr;
                curr.next = tempNext;
            }
            if (currPrev.next != currNext)
                currPrev = currPrev.next;
            curr = currNext;
        }
        return A;
    }
}
