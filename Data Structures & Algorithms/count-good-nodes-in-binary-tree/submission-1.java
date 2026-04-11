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
    int count = 0;
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, root, root.val);
        return count;

    }

    private void dfs(TreeNode root, TreeNode current, int max) {
        if (current == null) {
            return;
        }
        if (current.val >= root.val && current.val >= max) {
            max = current.val;
            count++;
        }
        dfs(root, current.left, max);
        dfs(root, current.right, max);
        }

    }

