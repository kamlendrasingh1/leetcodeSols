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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode n1 = head;

        int startJumps = 0;
        while(startJumps < k - 1){
            startJumps = startJumps + 1;
            n1 = n1.next;
        }

        ListNode nT1 = n1;
        ListNode n2 = head;

        while(nT1.next != null){
            nT1 = nT1.next;
            n2 = n2.next;
        }

        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;

        return head;
    }
}