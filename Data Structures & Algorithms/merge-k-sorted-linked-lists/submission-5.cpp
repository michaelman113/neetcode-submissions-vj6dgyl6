/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        priority_queue<int, vector<int>, greater<int>> pq;
        for (ListNode* li : lists) {
            while (li != nullptr) {
                pq.push(li->val);
                li = li->next;
            }
        }
        ListNode* curr = new ListNode();
        ListNode* dummy = curr;
        while (!pq.empty()) {
            int nexVal = pq.top(); pq.pop();
            curr->next = new ListNode(nexVal);
            curr = curr->next;
        }
        return dummy->next;
    }
};
