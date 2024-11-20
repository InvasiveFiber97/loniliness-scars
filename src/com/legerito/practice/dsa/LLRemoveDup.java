package com.legerito.practice.dsa;

public class LLRemoveDup {

    public static void main(String[] args) {

        ListNode list = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));

        ListNode result = deleteDuplicates(list);

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

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode res = head;

        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }

        return res;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
