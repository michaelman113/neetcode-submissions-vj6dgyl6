struct Job {
    int startTime;
    int endTime;
    int profit;
};

class Solution {
public:
    int jobScheduling(vector<int>& startTime, vector<int>& endTime, vector<int>& profit) {
        int n = startTime.size();
        vector<Job> jobs;
        for (int i = 0; i < n; i++) {
            jobs.push_back({startTime[i], endTime[i], profit[i]});
        }
        sort(jobs.begin(), jobs.end(), [] (const Job& job1, const Job& job2) {
            return job1.startTime < job2.startTime;
        });
        vector<int>dp(n, 0); //max profit from subset of jobs starting at Index I;
        dp[n-1] = jobs[n-1].profit;

        for (int i = n-2; i >= 0; i--) {
            Job nextJob = jobs[i];
            int maxProfitHere = nextJob.profit;
            //binary search from here
            int left = i + 1, right = n - 1;
            int nextIdx = -1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (jobs[mid].startTime >= nextJob.endTime) {
                    nextIdx = mid; //nextIdx is nearest next viable job
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            cout << nextIdx << '\n';
            if (nextIdx != -1) {
                maxProfitHere += dp[nextIdx];
            }


            dp[i] = max(dp[i+1], maxProfitHere);
        }
        return dp[0];
    }
};