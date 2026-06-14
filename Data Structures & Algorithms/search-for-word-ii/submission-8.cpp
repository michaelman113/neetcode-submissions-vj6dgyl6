class Solution {
public:
    struct TrieNode {
        bool isWord = false;
        unordered_map<char, TrieNode*> children;
    };

    TrieNode* root;

    void addWord(const string& word) {
        TrieNode* curr = root;
        for (char ch : word) {
            if (!curr->children.count(ch)) {
                curr->children[ch] = new TrieNode();
            }
            curr = curr->children[ch];
        }
        curr->isWord = true;
    }

    vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
        root = new TrieNode();
        for (const string& word : words) {
            addWord(word);
        }
        int m = board.size(), n = board[0].size();
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        vector<string> res;
        string path;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                dfs(board, r, c, root, visited, path, res);
            }
        }
        return res;
    }

    void dfs(vector<vector<char>>& board, int r, int c, TrieNode* node,
             vector<vector<bool>>& visited, string& path, vector<string>& res) {
        int m = board.size(), n = board[0].size();
        if (r < 0 || r >= m || c < 0 || c >= n) { 
            return;
        }
        if (visited[r][c]) {
            return;
        }
        char ch = board[r][c];
        if (!node->children.count(ch)) {
            return;
        }
        TrieNode* next = node->children[ch];
        path.push_back(ch);
        if (next->isWord) {
            res.push_back(path);
            next->isWord = false;
        }
        visited[r][c] = true;
        dfs(board, r + 1, c, next, visited, path, res);
        dfs(board, r - 1, c, next, visited, path, res);
        dfs(board, r, c + 1, next, visited, path, res);
        dfs(board, r, c - 1, next, visited, path, res);
        visited[r][c] = false;
        path.pop_back();
    }
};