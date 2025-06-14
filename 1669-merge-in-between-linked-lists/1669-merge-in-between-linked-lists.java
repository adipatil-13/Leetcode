class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode start = list1;
        for (int i = 0; i < a - 1; i++) {
            start = start.next;
        }

        ListNode between = start.next;
        for (int i = 0; i < b - a + 1; i++) {
            between = between.next;
        }

        start.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = between;

        return list1;
    }
}