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
        ListNode dummy = new ListNode(-1);
        ListNode output = dummy;
        ListNode temp1 = list1, temp2=list2;
        while(temp1!=null && temp2!=null){
            if(temp1.val<temp2.val){
                output.next = temp1;
                temp1 = temp1.next;
            }else{
                output.next = temp2;
                temp2 = temp2.next;
            }
            output = output.next;
        }
        // if there are any more elements left
        output.next = (temp1 != null) ? temp1 : temp2;
        return dummy.next;
    }
}