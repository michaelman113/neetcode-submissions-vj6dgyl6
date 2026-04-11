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
        for (ListNode* lis : lists) {
            while (lis != nullptr) {
                pq.push(lis->val);
                lis = lis->next;
            }
        }
        ListNode* res = new ListNode();
        ListNode* dummy = res;
        while (!pq.empty()) {
            int next = pq.top(); pq.pop();
            ListNode* nextNode = new ListNode(next);
            res->next = nextNode;
            res = res->next;
        }
        return dummy->next;
    }
};
