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
    public void reorderList(ListNode head) {
        /*
        Brute force O(n) and space : O(n) for extra array
        List<ListNode> nodes = new ArrayList<>();
        ListNode cur = head;
        while(cur!=null){
            nodes.add(cur);
            cur= cur.next;
        }

        int left = 1,right = nodes.size();
        ListNode output = head;
        for(int i=1;i<nodes.size();i++){
            if(i%2!=0){
                output.next = nodes.get(right-1);
                right--;
            } else{
                output.next = nodes.get(left);
                left++;
            }

            output = output.next;
        }
        output.next = null;
        */

        // Optimal O(n) 
        /*
         1. find Middle 
         2. reverse the second
         3. merge
         */


    if (head == null || head.next == null) {
        return;
    }

    // Step 1: Find middle
    ListNode slow = head;
    ListNode fast = head;

    while (fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    // Step 2: Reverse second half
    ListNode curr = slow.next;
    slow.next = null;

    ListNode prev = null;

    while (curr != null) {
        ListNode nextNode = curr.next;
        curr.next = prev;
        prev = curr;
        curr = nextNode;
    }

    // Step 3: Merge two halves
    ListNode first = head;
    ListNode second = prev;

    while (second != null) {

        ListNode firstNext = first.next;
        ListNode secondNext = second.next;

        first.next = second;
        second.next = firstNext;

        first = firstNext;
        second = secondNext;
    }


    }
}
