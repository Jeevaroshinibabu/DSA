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
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode t=head;
        int c=0;
        while(t!=null){
            c++;
            t=t.next;
        }
        int n=c/2;
       
        
        ListNode temp=head;
        ListNode p=null;
        for(int i=0;i<n;i++){
            p=temp;
            temp=temp.next;
        }
        p.next=temp.next;
        return head;
    }
}