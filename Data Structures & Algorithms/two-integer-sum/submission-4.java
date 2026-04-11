class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> ind = new HashMap<>(); //number, indicies

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (ind.containsKey(diff)) {
                return new int[] {ind.get(diff), i};
            }
            ind.put(nums[i], i);
        }
        return new int[] {};
    }
    
}
