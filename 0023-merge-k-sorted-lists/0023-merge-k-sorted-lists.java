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
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> arrayList = new ArrayList<>();
        for(int i = 0; i < lists.length; i++){
            ListNode iter = lists[i];
            while(iter != null){
                arrayList.add(iter.val);
                iter = iter.next;
            }
        }
        Collections.sort(arrayList);
        if(arrayList == null || arrayList.isEmpty()){
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for(int num : arrayList){
            curr.next = new ListNode(num);
            curr = curr.next;
        }
        return dummy.next;
    }
}
