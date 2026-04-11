/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result, 0); // Start at depth 0
        return result;
    }

    private void dfs(TreeNode root, List<Integer> list, int depth) {
        if (root == null) {
            return;
        }

        if (list.size() == depth) { // Only add if it's the first node at this depth
            list.add(root.val);
        }

        dfs(root.right, list, depth + 1); // Explore right first
        dfs(root.left, list, depth + 1);  // Then left
    }
}