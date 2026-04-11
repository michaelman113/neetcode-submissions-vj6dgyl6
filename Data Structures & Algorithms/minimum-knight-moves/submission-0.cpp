class Solution {
public:
    int minKnightMoves(int x, int y) {
        // Offset coordinates to handle negative values
        // Adding 310 ensures all coordinates are positive (safe range for -300 to 300)
        x += 310;
        y += 310;

        // Initialize the minimum number of moves
        int minMoves = 0;

        // BFS queue to store positions to explore
        queue<pair<int, int>> bfsQueue;
        bfsQueue.push({310, 310}); // Start from origin (0,0) with offset

        // Visited array to track explored positions
        vector<vector<bool>> visited(700, vector<bool>(700, false));
        visited[310][310] = true; // Mark starting position as visited

        // Eight possible knight moves: 2 squares in one direction, 1 square perpendicular
        vector<vector<int>> knightMoves = {
            {-2, 1}, {-1, 2}, {1, 2}, {2, 1},
            {2, -1}, {1, -2}, {-1, -2}, {-2, -1}
        };

        // BFS to find shortest path
        while (!bfsQueue.empty()) {
            // Process all positions at current distance level
            int levelSize = bfsQueue.size();
            for (int i = 0; i < levelSize; ++i) {
                // Get current position from queue
                auto [currentX, currentY] = bfsQueue.front();
                bfsQueue.pop();

                // Check if we've reached the target position
                if (currentX == x && currentY == y) {
                    return minMoves;
                }

                // Explore all eight possible knight moves from current position
                for (const auto& move : knightMoves) {
                    int nextX = currentX + move[0];
                    int nextY = currentY + move[1];

                    // If position hasn't been visited, mark it and add to queue
                    if (!visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        bfsQueue.push({nextX, nextY});
                    }
                }
            }
            // Increment move count after processing all positions at current level
            ++minMoves;
        }

        // Should never reach here as solution always exists
        return -1;
    }
};