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
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = 0;

        ListNode curr = head;

        while(curr != null){
            len = len + 1;
            curr = curr.next;
        }

        int times = len / k;

        curr = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode p1 = dummy;

        for(int i = 0; i < times; i++){

            ListNode prev = null;
            ListNode p2 = curr;
            int count = 0;

            while(count < k && curr != null){
                count++;

                ListNode next = curr.next;

                curr.next = prev;
                prev = curr;
                curr = next;
            }
            p1.next = prev;
            p2.next = curr;

            p1 = p2;
        }
        return dummy.next;
    }
}