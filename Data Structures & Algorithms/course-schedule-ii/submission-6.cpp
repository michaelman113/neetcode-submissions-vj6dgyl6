class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        //adjacency list qualifiers: directed graph, 
        //[a, b] = b must come before a
        //indegree = number of requirements for each course
        //start with courses of indegree 0
        //deduct one requirement from each adjacent course that requires it
        //if the indegree is now 0 then we take that course
        vector<vector<int>> adj(numCourses);
        vector<int> indegree(numCourses, 0);
        for (const auto& curr : prerequisites) {
            adj[curr[1]].push_back(curr[0]);
            indegree[curr[0]]++;
        }
        queue<int> q; //spare courses we can take
        for (int i = 0; i < indegree.size(); i++) {
            if (indegree[i] == 0) {
                q.push(i);
            }
        }
        vector<int> res;
        int completed = 0;
        while (!q.empty()) {
            int curr = q.front(); q.pop();
            res.push_back(curr);
            completed++;
            if (completed == numCourses) {
                return res;
            }
            for (const auto& nex : adj[curr]) {
                //the courses for which curr is a prerequisite
                indegree[nex]--;
                if (indegree[nex] == 0) {
                    q.push(nex);
                }
            }
        }
        return {};

    }
};


//example: [1,0]

//adj = 0 -> 1
//indegree = [0, 1, 0]
//queue = 0,2
//pop 0, completed = 1, add to res
//adj course is 1, --indegree[1] == 0, we can now take 1 so add to queue
//queue = 2,1
//pop 2, completed = 2, add to res
//pop 1, completed = 3, add to res
//completed == numCourses == 3 add to res

//example: [[0,1],[1,2],[2,0]]
//adj = 0 -> 2, 1 -> 0, 2 -> 1
//indegree = [1,1,1]
//cannot do anything so pause