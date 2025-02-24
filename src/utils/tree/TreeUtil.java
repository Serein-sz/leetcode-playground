package utils.tree;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王强
 * @since 2025/2/21
 */
public class TreeUtil {

    private TreeUtil() {
    }

    public static TreeNode buildTree(Integer[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        List<TreeNode> arrayList = new ArrayList<>();
        TreeNode root = new TreeNode(array[0]);
        arrayList.add(root);
        for (int i = 1; i < array.length; i += 2) {
            TreeNode treeNode = arrayList.get(0);
            TreeNode left = new TreeNode(array[i]);
            treeNode.left = left;
            arrayList.add(left);
            if (i + 1 < array.length) {
                TreeNode right = new TreeNode(array[i + 1]);
                treeNode.right = right;
                arrayList.add(right);
            }
            arrayList.remove(0);
        }
        return root;
    }

}
