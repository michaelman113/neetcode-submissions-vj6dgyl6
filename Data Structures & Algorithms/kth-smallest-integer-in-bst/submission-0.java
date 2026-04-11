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
    public int kthSmallest(TreeNode root, int k) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        list = inOrder(list, root);
        return list.get(k - 1).val;
    }

    private List<TreeNode> inOrder(List<TreeNode> list, TreeNode root) {
        if (root != null) {
            inOrder(list, root.left);
            list.add(root);
            inOrder(list, root.right);
        }
        return list;
    }
}
