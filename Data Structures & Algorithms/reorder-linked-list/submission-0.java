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
    }
}
