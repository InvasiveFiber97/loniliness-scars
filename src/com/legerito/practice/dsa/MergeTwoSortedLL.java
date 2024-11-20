package com.legerito.practice.dsa;

public class MergeTwoSortedLL {

    public static void main(String[] args) {
        ListNode one = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode two = new ListNode(1, new ListNode(3, new ListNode(4)));

        ListNode result = mergeTwoLists(one, two);

        ListNode temp;
        System.out.print("[");
        while (true) {
            temp = result;
            System.out.print(result.val);
            if(result.next != null) {
                System.out.print(", ");
                result = temp.next;
            } else {
                break;
            }
        }
        System.out.println("]");
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Attach the remaining nodes from the non-exhausted list
        if (list1 != null) current.next = list1;
        else current.next = list2;

        return dummy.next;  // Return the head of the merged list

    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
