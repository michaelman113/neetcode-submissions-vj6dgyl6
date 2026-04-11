class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        backtrack(nums, new ArrayList<>());
        System.out.print("final res:");
        System.out.println(res);
        return res;
    }

    private void backtrack(int[] nums, List<Integer> current) {
        if (current.size() == nums.length) {
            System.out.print(current);
            System.out.println("add");
            res.add(new ArrayList<>(current));
            System.out.println(res);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!current.contains(nums[i])) {
                current.add(nums[i]);
                System.out.println(current);
                backtrack(nums, current);
                current.remove(current.size()-1);
            }
        }
    }
}
