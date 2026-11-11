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
        // BRUTE FORCE : 
        // List<Integer> list = new ArrayList<>();
        // for(ListNode node: lists){
        //    ListNode cur = node;
        //     while(cur!=null){
        //         list.add(cur.val);
        //         cur = cur.next;
        //     }
        // }
        // Collections.sort(list);
        // ListNode output = new ListNode(-1);
        // ListNode temp = output;
        // int n = list.size();
        // for(int i=0;i<list.size();i++){
        //     ListNode newNode = new ListNode(list.get(i));
        //     output.next = newNode;
        //     output = output.next;
        // }
        // return temp.next;

    if (lists == null || lists.length == 0) {
        return null;
    }

    ListNode result = lists[0];

    for (int i = 1; i < lists.length; i++) {
        result = mergeLists(result, lists[i]);
    }

    return result;
}

private ListNode mergeLists(ListNode head1, ListNode head2) {

    ListNode dummy = new ListNode(-1);
    ListNode output = dummy;

    while (head1 != null && head2 != null) {

        if (head1.val <= head2.val) {
            output.next = head1;
            head1 = head1.next;
        } else {
            output.next = head2;
            head2 = head2.next;
        }

        output = output.next;
    }

    output.next = (head1 != null) ? head1 : head2;

    return dummy.next;
}
}
