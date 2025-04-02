/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head, fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return mergeSort(left, right);
    }

    private ListNode mergeSort(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode sorted = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                sorted.next = list2;
                list2 = list2.next;
            } else {
                sorted.next = list1;
                list1 = list1.next;
            }
            
            sorted = sorted.next;
        }

        if (list1 != null) sorted.next = list1;
        else  sorted.next = list2;

        return dummy.next;
    }
}