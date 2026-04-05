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
    public ListNode mergeTwoLists(ListNode t, ListNode t1){
        while(t!=null&&t1!=null){
            if(t.val<t1.val){
                t.next=mergeTwoLists(t.next,t1);
                return t;
            }else{
                t1.next=mergeTwoLists(t,t1.next);
                return t1;
            }
        }
        if(t==null){
            return t1;
        }
           
       return t;
    }
}