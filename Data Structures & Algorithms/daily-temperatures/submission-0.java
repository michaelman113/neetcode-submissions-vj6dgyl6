class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] returning = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int count = 0;
            for (int k = i + 1; k < temperatures.length; k++) {
                if (temperatures[k] > temperatures[i]) {
                    returning[i] = k - i;
                    count++;
                    break;
                } 
            }
            if (count == 0) {
                returning[i] = 0;
            }
        }
        return returning;
    }
}
