class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        backtrack(nums, target, new ArrayList<>(), 0);
        return res;
    }

    private void backtrack(int[] nums, int target, List<Integer> curr, int j) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = j; i < nums.length; i++) {
            curr.add(nums[i]);
            backtrack(nums, target - nums[i], curr, i);
            curr.remove(curr.size() - 1);
        }
    }

}
