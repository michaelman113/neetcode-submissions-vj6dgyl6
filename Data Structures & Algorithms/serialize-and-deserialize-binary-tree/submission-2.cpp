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

class Codec {
public:
    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        string resul = "";
        serializeDfs(root, resul);
        return resul;
    }

    void serializeDfs(TreeNode* curr, string& resul) {
        resul += (curr != nullptr) ? to_string(curr->val) : "N";
        resul += "/"; //delimiter
        if (curr != nullptr) {
            serializeDfs(curr->left, resul);
            serializeDfs(curr->right, resul);
        }
    }
    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        stringstream ss(data);
        TreeNode* newT = streamTraverse(ss);
        return newT;
    }

    TreeNode* streamTraverse(stringstream& ss) {
        string nextCh;
        getline(ss, nextCh, '/');
        if (nextCh == "N") {
            return nullptr;
        } else {
            int nex = stoi(nextCh);
            TreeNode* curr = new TreeNode(nex);
            TreeNode* left = streamTraverse(ss);
            TreeNode* right = streamTraverse(ss);
            curr->left = left;
            curr->right = right;
            return curr;
        }
    }

};
