class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        //likely adjacency list needed
        int n = prerequisites.size();
        vector<vector<int>> adj(numCourses);
        vector<int> indegree(numCourses);
        for (int i = 0; i < n; i++) {
            int from = prerequisites[i][0], to = prerequisites[i][1];
            adj[to].push_back(from);
            indegree[from]++;
        }
        int courses = 0;
        vector<int> res;
        queue<int> q; //queue represents classes we can currently take
        for (int i = 0; i < indegree.size(); i++) {
            if (indegree[i] == 0) {
                q.push(i);
            }
        }
        while (!q.empty()) {
            int nex = q.front(); q.pop();
            res.push_back(nex);
            courses++;
            if (courses == numCourses) {
                return res;
            }
            for (int nextCourse : adj[nex]) {
                indegree[nextCourse]--;
                if (indegree[nextCourse] == 0) {
                    q.push(nextCourse);
                }
            }
        }
        vector<int> failedRes;
        return failedRes;
    }
};

//3, (10)
//adj = [0 -> 1]
//indegree = (1, 0);
//q = (1)
//res = 1
//indegree[0] = 0;
//