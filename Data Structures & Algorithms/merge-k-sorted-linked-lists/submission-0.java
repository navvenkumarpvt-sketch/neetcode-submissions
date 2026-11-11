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
        List<Integer> list = new ArrayList<>();
        for(ListNode node: lists){
           ListNode cur = node;
            while(cur!=null){
                list.add(cur.val);
                cur = cur.next;
            }
        }
        Collections.sort(list);
        ListNode output = new ListNode(-1);
        ListNode temp = output;
        int n = list.size();
        for(int i=0;i<list.size();i++){
            ListNode newNode = new ListNode(list.get(i));
            output.next = newNode;
            output = output.next;
        }
        return temp.next;
    }
}
