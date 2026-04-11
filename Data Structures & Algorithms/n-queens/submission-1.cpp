class Solution {
public:
    // Main function to solve N-Queens problem
    vector<vector<string>> solveNQueens(int n) {
        vector<vector<string>> res;                        // Stores all valid board configurations
        vector<string> board(n, string(n, '.'));           // Initializes an empty board of size n x n
        backtrack(0, board, res);                          // Start backtracking from the first row
        return res;                                        // Return all valid solutions
    }

    // Recursive function to place queens row by row
    void backtrack(int r, vector<string>& board, vector<vector<string>>& res) {
        // Base case: All rows filled, valid configuration found
        if (r == board.size()) {
            res.push_back(board);                          // Add the current valid board to results
            return;
        }

        // Try placing a queen in every column of the current row
        for (int c = 0; c < board.size(); c++) {
            if (isSafe(r, c, board)) {                     // Only proceed if placing at (r, c) is safe
                board[r][c] = 'Q';                         // Place the queen
                backtrack(r + 1, board, res);              // Recurse for next row
                board[r][c] = '.';                         // Backtrack: remove the queen
            }
        }
    }

    // Helper function to check if placing a queen at (r, c) is safe
    bool isSafe(int r, int c, vector<string>& board) {
        // Check the column above the current cell
        for (int i = r - 1; i >= 0; i--) {
            if (board[i][c] == 'Q') return false;          // Another queen in same column
        }

        // Check the upper-left diagonal
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;          // Another queen in upper-left diagonal
        }

        // Check the upper-right diagonal
        for (int i = r - 1, j = c + 1; i >= 0 && j < board.size(); i--, j++) {
            if (board[i][j] == 'Q') return false;          // Another queen in upper-right diagonal
        }

        return true;                                       // Safe to place the queen
    }
};
