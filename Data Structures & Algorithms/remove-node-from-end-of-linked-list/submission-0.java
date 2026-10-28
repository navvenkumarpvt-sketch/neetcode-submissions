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
public ListNode removeNthFromEnd(ListNode head, int n) {
    int size = 0;
    ListNode curr = head;

    while (curr != null) {
        size++;
        curr = curr.next;
    }

    int removalNode = size - n;

    // If the head node needs to be removed
    if (removalNode == 0) {
        return head.next;
    }

    ListNode next = head;
    int i = 1;

    while (i < removalNode) {
        next = next.next;
        i++;
    }

    // Skip the node to be removed
    next.next = next.next.next;

    return head;
}
}
