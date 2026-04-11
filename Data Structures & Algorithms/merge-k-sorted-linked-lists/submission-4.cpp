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
        //priority queue
        priority_queue<int, vector<int>, greater<int>> pq; //minHeap
        for (auto li : lists) { //[1,2,4] 
            while (li != nullptr) {
                pq.push(li->val); //pushes 1, 2, 4
                li = li->next;
            }
        }
        //O(n log n) n = lists.size();
        ListNode* head = new ListNode();
        ListNode* dummy = head;
        while (!pq.empty()) {
            int val = pq.top(); pq.pop();
            head->next = new ListNode(val);
            head = head->next;
        }
        return dummy->next;
    }
};

//ex: pq: 1 1 2 3 3 4 5 6
//
