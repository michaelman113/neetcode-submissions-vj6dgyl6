/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        // Use a min-heap to always have efficient access to the smallest node.
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        // Add the head of each of the k lists into the min-heap.
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        ListNode res = new ListNode(0); // Create a dummy head to simplify building the result list.
        ListNode cur = res; // 'cur' is the pointer to the tail of our result list.

        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll(); // Get the node with the smallest value from all k lists.
            cur.next = node; // Append this smallest node to the result list.
            cur = cur.next; // Move the tail pointer forward.

            // If the list we just took from has more nodes, add the next one to the heap.
            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }
        return res.next; // The merged list starts after our dummy head.
    }
}