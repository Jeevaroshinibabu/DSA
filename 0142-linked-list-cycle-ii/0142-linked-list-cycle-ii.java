/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null){
            return null;

        }
        ListNode s=head;
        ListNode f=head;
        boolean t=false ;
        while(f!=null&&f.next!=null){
            f=f.next.next;
            s=s.next;
            if(f==s){
                t=true;
                break;
            }
        }
        if(!t){
            return null;
        }
        ListNode r=head;
        while(r!=s){
            r=r.next;
            s=s.next;
        }
        return r;
    }
}