import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 102
 * @author youyusong
 * @date 2018/8/27
 */
public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        // Pair : 提供了一种方式来处理简单的键值关联，当我们想从方法返回两个值时特别有用。
        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.addLast(new Pair<>(root, 0));

        while (! queue.isEmpty()){
            Pair<TreeNode, Integer> front = queue.removeLast();
            TreeNode node = front.getKey();
            int level = front.getValue();

            // 此时说明当前层级下没有位置来来添加元素, res 需要增加位置简介增加层级
            if (level == queue.size()) {
                res.add(new ArrayList<>());
            }
            res.get(level).add(node.val);
            if (node.left != null) {
                queue.addLast(new Pair<>(node.left, level + 1));
            }
            if (node.right != null) {
                queue.addLast(new Pair<>(node.right, level + 1));
            }
        }
        return res;
    }
}
