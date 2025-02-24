package L2025.L02.L1530;

import utils.TreeNode;
import utils.tree.TreeUtil;

/**
 * @author 王强
 * @since 2025/2/21
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        TreeNode root = TreeUtil.buildTree(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println("main.countPairs(root, 3) = " + main.countPairs(root, 3));
    }

    public int countPairs(TreeNode root, int distance) {

        return 0;
    }

}
