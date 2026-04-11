class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> st = new Stack<>();
        int[] res = new int[temperatures.length];
        //(30,0) (38,1)
        for (int i = 0; i < temperatures.length; i++) {
            while (!st.isEmpty() && st.peek()[0] < temperatures[i]) {
                res[st.peek()[1]] = i - st.peek()[1];
                st.pop();
            }
            st.add(new int[]{temperatures[i], i});
        }
        return res;
    }
}
