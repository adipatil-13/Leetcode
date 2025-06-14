
class Solution {
    public ListNode removeNodes(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newNode = reverse(head);
        ListNode dummy = new ListNode();
        ListNode curr = newNode;
        int max = Integer.MIN_VALUE;

        while (curr != null) {
            if (curr.val >= max) {
                max = curr.val;
                ListNode next = curr.next;
                curr.next = dummy.next;
                dummy.next = curr;
                curr = next;
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }
    public ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
/*First iteration (curr = 8):
max is MIN_VALUE, so 8 >= max is true
max becomes 8
dummy → 8 → null

Second iteration (curr = 3):
3 < 8, so we skip it
The list stays: dummy → 8 → null

Third iteration (curr = 13):
13 > 8, so we keep it
max becomes 13
dummy → 13 → 8 → null

Fourth iteration (curr = 2):
2 < 13, so we skip it
The list stays: dummy → 13 → 8 → null

Fifth iteration (curr = 5):
5 < 13, so we skip it
The list stays: dummy → 13 → 8 → null*/