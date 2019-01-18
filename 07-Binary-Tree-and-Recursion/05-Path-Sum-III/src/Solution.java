/**
 * leetcode 437
 * @author youyusong
 * @date 2018/8/27
 */
public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        return findPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    /**
     * 在以node为根节点的二叉树中,寻找包含node的路径,和为sum
     * @param node
     * @param num
     * @return
     */
    private int findPath(TreeNode node, int num) {
        if (node == null) {
            return 0;
        }
        int res = 0;

        // res += 1, 当前的节点它的 val 等于 num, 有可能它和后续的节点加在一起又等于 num
        if (node.val == num) {
            res += 1;
        }
        res += findPath(node.left, num - node.val);
        res += findPath(node.right, num - node.val);
        return res;
    }

}
