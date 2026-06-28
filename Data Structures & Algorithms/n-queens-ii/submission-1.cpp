class Solution {
public:
    int res = 0;
    int totalNQueens(int n) {
        vector<vector<int>> board(n, vector<int>(n, 0));
        int queens = n;
        backtrack(0,n,board,queens);
        return res;
    }


    void backtrack(int r, int n, vector<vector<int>>& board, int queens) {
        if (queens == 0) { //decrement after each call, if no more queens to place, we're done
            res++;
            return;
        }
        for (int k = 0; k < n; k++) {
            if (isValid(r,k,n,board)) {
                board[r][k] = 1;
                queens--;
                backtrack(r+1,n,board,queens);
                board[r][k] = 0;
                queens++;
            }
        }
    }

    bool isValid(int r, int c, int n, vector<vector<int>>& board) {
        //check if row where queen wants to be placed is valid
        for (int i = 0; i < n; i++) {
            if (board[r][i] == 1) {
                return false;
            }
        }
        //check if col where queen wants to be placed is valid
        for (int i = 0; i < n; i++) {
            if (board[i][c] == 1) {
                return false;
            }
        }
        //upper right diagonal
        for (int i = r, k = c; i >= 0 && i < n && k >= 0 && k < n; i--, k++) {
            if (board[i][k] == 1) {
                return false;
            }
        }
        //bottom right diagonal
        for (int i = r, k = c; i >= 0 && i < n && k >= 0 && k < n; i++, k++) {
            if (board[i][k] == 1) {
                return false;
            }
        }
        //upper left diagonal
        for (int i = r, k = c; i >= 0 && i < n && k >= 0 && k < n; i--, k--) {
            if (board[i][k] == 1) {
                return false;
            }
        }
        for (int i = r, k = c; i >= 0 && i < n && k >= 0 && k < n; i++, k--) {
            if (board[i][k] == 1) {
                return false;
            }
        }
        return true;
        
    }
};
//backtracking = number of options^number of times we have to choose
