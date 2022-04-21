package com.practice.sp.solutions;

public class LinkedListCycle {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * Leetcode# 141
     * https://leetcode.com/problems/linked-list-cycle/
     * Fast and slow pointer method. Works because of Floyd's tortoise and hare algorithm
     */
    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) return true;
        }

        return false;
    }

    /**
     * Leetcode 142
     * https://leetcode.com/problems/linked-list-cycle-ii/
     * Explainer: https://www.youtube.com/watch?v=wjYnzkAhcNk
     */
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;
        ListNode entry = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                while (entry != slow) {
                    entry = entry.next;
                    slow = slow.next;
                }
                return entry;
            }
        }

        return null;
    }
}
