class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode dummy = new ListNode( -1, head);

        boolean[] rm = new boolean[100001];

        for (int num : nums) {
            rm[num] = true;
        }
        ListNode prev = dummy;

        while (head != null) {
            if (rm[head.val]) {
                prev.next = head.next;
                head = prev.next;
            } else {
                prev = head;
                head = head.next;
            }
        }

        return dummy.next;
    }
}