class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = new ListNode(0, head);
        ListNode temp = res;

        for (int i = 0; i < n; i++) {
            head = head.next;
        }
        
        while (head != null) {
            temp = temp.next;
            head = head.next;
        }

        temp.next = temp.next.next;
        return res.next;
    }
}