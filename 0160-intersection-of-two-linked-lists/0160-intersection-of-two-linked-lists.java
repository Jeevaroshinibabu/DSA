/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode t=headA;
        while(t!=null){
            ListNode r=headB;
            while(r!=null){
                if(t==r){
                    return t;
                }
                r=r.next;
            }
            t=t.next;

        }
        return null;
    }
}