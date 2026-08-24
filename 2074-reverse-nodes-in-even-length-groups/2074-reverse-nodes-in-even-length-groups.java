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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        int len = 0;
        int probGroupSize = 1;

        ListNode curr = head;
        while(curr != null){
            len = len + 1;
            curr = curr.next;
        }
        curr = head;
        ListNode p = null;

        while(curr != null){
            int actualGroupSize = Math.min(probGroupSize, len);

            if(actualGroupSize % 2 == 0){
                ListNode prev = null;
                int counter = 0;
                ListNode temp1 = curr;
                while(counter < actualGroupSize){
                    counter = counter + 1;
                    ListNode next = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = next;
                }
                p.next = prev;
                temp1.next = curr;
                p = temp1;
            }else{
                int counter = 0;
                while(counter < actualGroupSize){
                    counter = counter + 1;
                    p = curr;
                    curr = curr.next;
                }
            }
            probGroupSize = probGroupSize + 1;
            len = len - actualGroupSize;
        }
        return head;
    }
}