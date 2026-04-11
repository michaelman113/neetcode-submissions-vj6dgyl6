class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] twoSum1 = new int[2];
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int k = i + 1; k < numbers.length; k++) {
                if (numbers[i] + numbers[k] == target) {
                    twoSum1[0] = i + 1;
                    twoSum1[1] = k + 1;
                }
            }
        }
        return twoSum1;
    }
}
