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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode li : lists) {
            if (li != null) {
                pq.add(li);
            }
            li = li.next;
        }
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();
            cur.next = curr;
            cur = cur.next;
            if (curr.next != null) {
                pq.add(curr.next);
            }
        }
        return res.next;
    }
}
