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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null; // Previous node starts as NULL
        ListNode next = null; // Next node
        ListNode curr = head;    // Current node starts at the head

        // Traverse the list
        while (curr != null) {
            // Save the next node
            next = curr.next;

            // Reverse the link
            curr.next = prev;

            // Move pointers forward
            prev = curr; // Move prev to the current node
            curr = next; // Move curr to the next node
        }

        // prev is now the new head of the reversed list
        return prev;
    }
}
