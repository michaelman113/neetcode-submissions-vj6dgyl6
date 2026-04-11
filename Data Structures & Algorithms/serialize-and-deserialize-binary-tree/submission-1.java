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

public class Codec {
    private static final String NULL_SYMBOL = "#";
    private static final String DELIMITER = ",";

    // Converts the tree to a string using pre-order DFS
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();// Join list into comma-separated string
    }

    // Helper for pre-order DFS serialization
    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NULL_SYMBOL).append(DELIMITER);
        } else {
            sb.append(node.val).append(DELIMITER);
            buildString(node.left, sb);
            buildString(node.right, sb);
        }          // Recurse right
    }

    // Converts string back to tree
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(DELIMITER)));
        return buildTree(nodes);
    }

    // Helper for deserialization using pre-order structure
    private TreeNode buildTree(Queue<String> nodes) {
        String val = nodes.poll();
        if (val.equals(NULL_SYMBOL)) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.parseInt(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}
