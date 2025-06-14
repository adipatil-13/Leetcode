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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        int first = Integer.MAX_VALUE, last = -1;
        int prev_val = head.val, min_diff = Integer.MAX_VALUE;

        ListNode curr = head.next;
        ListNode next = curr.next;
        int index = 1;

        while (next != null) {
            if ((prev_val < curr.val && curr.val > next.val) || 
                (prev_val > curr.val && curr.val < next.val)) {
                if (last != -1) {
                    min_diff = Math.min(min_diff, index - last);
                }
                if (first == Integer.MAX_VALUE) {
                    first = index;
                }
                last = index;
            }
            prev_val = curr.val;
            curr = next;
            next = next.next;
            index++;
        }

        if (min_diff == Integer.MAX_VALUE) {
            return new int[] {-1, -1};
        }
        return new int[] {min_diff, last - first};
    }
}