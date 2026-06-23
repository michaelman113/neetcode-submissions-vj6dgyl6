/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */

class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> res;
        if (root == nullptr) {
            return res;
        }
        queue<TreeNode*> q;
        q.push(root);
        while (!q.empty()) {
            int curr = q.size();
            vector<int> currLevel;
            for (int i = 0; i < curr; i++) {
                TreeNode* nex = q.front(); q.pop();
                currLevel.push_back(nex->val);
                if (nex->left != nullptr) {
                    q.push(nex->left);
                }
                if (nex->right != nullptr) {
                    q.push(nex->right);
                } 
            }
            res.push_back(currLevel);
        }



        return res;
    }
};
