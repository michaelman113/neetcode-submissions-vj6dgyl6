class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int result[] = new int[n + 1];
        int int_max = Integer.MAX_VALUE;
        Arrays.fill(result, int_max);
        result[k] = 0;

        for(int i = 0; i < n - 1; i++) {
            boolean found = false;

            for(int time[] : times) {
                int src = time[0];
                int dest = time[1];
                int t = time[2];

                if(result[src] == int_max) continue;
                if(result[src] + t < result[dest]) {
                    found = true;
                    result[dest] = result[src] + t;
                }
            }
            if(found == false) break;
        }
        int answer = -1;
        for(int i = 1; i < n + 1; i++) {
            if(result[i] == int_max) return -1;
            answer = Math.max(answer, result[i]);
        }
        return answer;
    }
}