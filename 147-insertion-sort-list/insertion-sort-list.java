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
    public ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null) return head;
        ArrayList<Integer> a=new ArrayList<>();
        ListNode c=head;
        while(c!=null){
            a.add(c.val);
            c=c.next;
        }
        Collections.sort(a);
        c=head;

        for(int i: a){
            c.val=i;
            c=c.next;
        }
        return head;
        
    }
}