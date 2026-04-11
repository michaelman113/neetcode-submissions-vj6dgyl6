class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // We'll use a stack to keep track of days we haven't found a warmer day for yet.
        // The stack will store pairs of [temperature, index].
        Stack<int[]> st = new Stack<>();
        // The result array is initialized to all zeros by default.
        int[] res = new int[temperatures.length];

        // Let's go through the temperatures day by day.
        for (int i = 0; i < temperatures.length; i++) {
            // Now for the key part. Let's look at the current day's temperature.
            // Is it warmer than the day at the top of our stack?
            while (!st.isEmpty() && st.peek()[0] < temperatures[i]) {
                // If it is, then we've found the answer for the day on the stack.
                int[] pastDay = st.pop();
                int pastTemp = pastDay[0];
                int pastIndex = pastDay[1];
                
                // The number of days to wait is just the difference in our indices.
                res[pastIndex] = i - pastIndex;
            }
            
            // Now, let's add the current day to the stack.
            // It will wait there until we find a future day that's warmer than it.
            st.add(new int[]{temperatures[i], i});
        }
        
        // Any days left in the stack never found a warmer day,
        // so their result value correctly remains 0.
        return res;
    }
}