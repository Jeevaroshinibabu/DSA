import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Handle edge cases for empty inputs
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        // Initialize a Min-Heap based on the node values
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        
        // Push the head node of each non-empty linked list into the heap
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.add(node);
            }
        }
        
        // Dummy head acts as a placeholder for the merged list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        // Process the heap until it is empty
        while (!minHeap.isEmpty()) {
            // Extract the smallest node from the heap
            ListNode smallestNode = minHeap.poll();
            current.next = smallestNode;
            current = current.next;
            
            // If the extracted node has a next node, add it to the heap
            if (smallestNode.next != null) {
                minHeap.add(smallestNode.next);
            }
        }
        
        return dummy.next;
    }
}
