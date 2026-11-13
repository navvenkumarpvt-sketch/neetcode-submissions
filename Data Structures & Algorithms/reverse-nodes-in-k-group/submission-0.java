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

        // 1 -> 2 -> 3 -> 4 -> 5 (input) k = 2
        // null <- 1 <- 2  3->4->5  (first time/group reversal)
        ListNode cur = head;
        ListNode tail = null;
        ListNode newHead = null;
        while (cur != null) {

        // Check whether k nodes are available
        ListNode check = cur;
        int count = 0;

        while (count < k && check != null) {
            check = check.next;
            count++;
        }

        // Fewer than k nodes remain
        if (count < k) {
            if (tail != null) {
                tail.next = cur;
            }
            break;
        }

        ListNode groupHead = cur;
        ListNode prev = null;
        int counter = 0;

        while (counter < k && cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            counter++;
        }

        if (newHead == null) {
            newHead = prev;
        }

        if (tail != null) {
            tail.next = prev;
        }

        tail = groupHead;
    }
    return newHead;
    }
}
