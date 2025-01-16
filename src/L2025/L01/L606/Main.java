package L2025.L01.L606;

import utils.TreeNode;

/**
 * @author 王强
 * @since 2025/1/15
 */
public class Main {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3));
        System.out.println(new Main().tree2str(treeNode));
    }

    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            return sb.toString();
        }
        sb.append("(").append(tree2str(root.left)).append(")");
        if (root.right != null) {
            sb.append("(").append(tree2str(root.right)).append(")");
        }
        return sb.toString();
    }

}