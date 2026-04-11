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
    int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Recursively get the maximum path sum from left and right subtrees
        // Discard negative path sums by taking max with 0
        int leftGain = Math.max(0, maxGain(node.left));
        int rightGain = Math.max(0, maxGain(node.right));

        // Calculate the maximum path sum with the current node as the "pivot"
        // This is a potential candidate for the overall maximum path sum
        int currentPathSum = node.val + leftGain + rightGain;
        
        // Update the global maximum sum
        maxSum = Math.max(maxSum, currentPathSum);

        // Return the maximum gain for a path that can be extended by the parent node.
        // This path must go "straight" down from the parent.
        return node.val + Math.max(leftGain, rightGain);
    }
}
