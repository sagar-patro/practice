package com.practice.sp.solutions;


public class LinkedListRelated {

      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    /**
     * Leetcode# 206
     * https://leetcode.com/problems/reverse-linked-list/
     * @return
     */
    public static ListNode reverseList(ListNode head) {

        if(head == null) return null;

        ListNode current = head;
        ListNode previous = null;

        while(current.next != null) {
            head = current.next;
            current.next = previous;
            previous = current;
            current = head;
        }
        head.next = previous;
        return head;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode result = l3;

        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                l3.next = new ListNode(l1.val);
                l1 = l1.next;
                l3 = l3.next;
            } else {
                l3.next = new ListNode(l2.val);
                l2 = l2.next;
                l3 = l3.next;
            }
        }

        while(l1 != null) {
            l3.next = new ListNode(l1.val);
            l1 = l1.next;
            l3 = l3.next;
        }

        while(l2 != null) {
            l3.next = new ListNode(l2.val);
            l2 = l2.next;
            l3 = l3.next;
        }

        return result.next;
    }

    public static void main(String[] args) {
        ListNode head = null/*[1,2,3,4,5]*/;
        reverseList(head); // 5, 4, 3, 2, 1

        ListNode list1 = null/*[1,2,4]*/;
        ListNode list2 = null/*[1,3,4]*/;
        mergeTwoLists(list1, list2); // [1,1,2,3,4,4]
    }
}
