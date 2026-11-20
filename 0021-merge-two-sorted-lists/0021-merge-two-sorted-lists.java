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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode res = new ListNode();
        ListNode temp = res;

        ListNode curr = list1;
        ListNode ahead = list2;

        while (curr != null && ahead != null) {

            if (curr.val < ahead.val) {
                temp.next = curr;
                curr = curr.next;
            } else {
                temp.next = ahead;
                ahead = ahead.next;
            }
            temp = temp.next;
        }
        if (curr != null) {
            temp.next = curr;
        } else {
            temp.next = ahead;
        }
        return res.next;
    }
}
