class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        //O(v+e) = V = num courses, E = prerequisites
        vector<vector<int>> adj(numCourses);
        vector<int> indegree(numCourses, 0);
        for (const auto& pre : prerequisites) {
            int from = pre[0], to = pre[1];
            adj[to].push_back(from);
            indegree[from]++;
        }
        queue<int> q;
        for (int i = 0; i < indegree.size(); i++) {
            if (indegree[i] == 0) {
                q.push(i);
            }
        }
        vector<int> res;
        int day = 0;
        while (!q.empty()) {
            int nexCourse = q.front(); q.pop();
            res.push_back(nexCourse);
            day++;
            if (day == numCourses) {
                return res;
            }
            for (auto nex : adj[nexCourse]) {
                indegree[nex]--;
                if (indegree[nex] == 0) {
                    q.push(nex);
                }
            }
        }
        return {};

        //[0       1
        //queue = (0,2)
        //q.push(0) 

        //[]
    }
};
