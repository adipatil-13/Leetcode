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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
    
        int length = 1;
        ListNode last = head;
        while(last.next != null){
            last = last.next;
            length++;
        }

        k = k % length;

        if (k == 0) return head;

        ListNode curr = head;
        for (int i = 0; i < length - k - 1; i++) {
            curr = curr.next;
        }

        ListNode newHead = curr.next;
        curr.next = null;
        last.next = head;
        
        return newHead;

    }
}