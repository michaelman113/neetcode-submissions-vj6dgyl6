class Solution {
    public int removeDuplicates(int[] nums) {
        TreeSet<Integer> res = new TreeSet();
        for (int n : nums) {
            if (!res.contains(n)) {
                res.add(n);
            }
        }
        int index = 0;
        for (int r : res) {
            nums[index] = r;
            index++;
        }
        return res.size();
    }
}