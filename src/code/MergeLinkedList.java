package code;

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class MergeLinkedList {

    public static void main(String[] args) {

        ListNode l1_1 = new ListNode(-9);
        ListNode l1_3 = new ListNode(3);
        // ListNode l1_5 = new ListNode(5);
        l1_1.next = l1_3;
        // l1_3.next = l1_5;

        ListNode l1_2 = new ListNode(5);
        ListNode l1_4 = new ListNode(7);
        l1_2.next = l1_4;

        mergeTwoLists(l1_1, l1_2);

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode curr = null;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                if (head == null) {
                    head = l1;
                    curr = head;
                } else {
                    curr.next = l1;
                    curr = curr.next;
                }
                l1 = l1.next;
            } else {
                if (head == null) {
                    head = l2;
                    curr = head;
                } else {
                    curr.next = l2;
                    curr = curr.next;
                }
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            if (head == null) {
                head = l1;
                curr = head;
            } else {
                curr.next = l1;
                curr = curr.next;
            }
            l1 = l1.next;
        }
        while (l2 != null) {
            if (head == null) {
                head = l2;
                curr = head;
            } else {
                curr.next = l2;
                curr = curr.next;
            }
            l2 = l2.next;
        }
        return head;
    }
}