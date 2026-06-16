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
        ListNode nn=null;
        ListNode c=head;
        ListNode p=null;
        while(c!=null){
            nn=c.next;
            c.next=p;
            p=c;
            c=nn;
        }
        ListNode nh=p;
        if(n==1){
            nh=nh.next;
        }else{
        for(int i=0;i<n-2;i++){
            if(p!=null){
            p=p.next;}
        }
        if (p != null && p.next != null) {
                p.next = p.next.next;
            }
            }
        ListNode t=null;
        ListNode cu=nh;
        ListNode prev=null;
        while(cu!=null){
            t=cu.next;
            cu.next=prev;
            prev=cu;
            cu=t;
        }
    
        return prev;
    }
}