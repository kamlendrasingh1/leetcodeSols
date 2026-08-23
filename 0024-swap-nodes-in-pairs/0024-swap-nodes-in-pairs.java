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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr1 = head;
        ListNode prev = dummy;

        while(curr1 != null && curr1.next != null){
            ListNode curr2 = curr1.next;
            prev.next = curr2;
            curr1.next = curr2.next;
            curr2.next = curr1;

            prev = curr1;
            curr1 = curr1.next;
        }
        return dummy.next;
    }
}