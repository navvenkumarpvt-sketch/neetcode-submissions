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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // StringBuilder sb1 = "";
        // StringBuilder sb2 = "";
        // ListNode cur1 = l1, cur2=l2;
        // while(cur1!=null){
        //     sb1.append(cur1.value);
        //     cur1=cur1.next;
        // }

        //  while(cur2!=null){
        //     sb2.append(cur2.value);
        //     cur2=cur2.next;
        // }

        // Long output = Long.parseLong(sb1.reverse()) + sb2.parseLong(sb2.reverse());
        // ListNode outputNode = new Node(-1);
        // ListNode prev = outputNode;
        // while(output>0){
        //     ListNode next = new ListNode(output%10);
        //     outputNode.next = next;
        //     output = output//10;
        // }
        // return prev.next;
        ListNode dummy = new ListNode(0);
    ListNode current = dummy;
    int carry = 0;

    while (l1 != null || l2 != null || carry != 0) {
        int sum = carry;

        if (l1 != null) {
            sum += l1.val;
            l1 = l1.next;
        }

        if (l2 != null) {
            sum += l2.val;
            l2 = l2.next;
        }

        carry = sum / 10;
        current.next = new ListNode(sum % 10);
        current = current.next;
    }

    return dummy.next;
    }
}
