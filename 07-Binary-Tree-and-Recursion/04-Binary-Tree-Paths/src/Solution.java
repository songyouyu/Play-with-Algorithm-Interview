import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 257
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

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return null;
        }

        ArrayList<String> res = new ArrayList<>();
        if (root.left == null && root.right == null) {
            res.add(Integer.toString(root.val));
        }
        List<String> left = binaryTreePaths(root.left);
        for(String s: left){
            StringBuilder sb = new StringBuilder(Integer.toString(root.val));
            sb.append("->");
            sb.append(s);
            res.add(sb.toString());
        }
        List<String> right = binaryTreePaths(root.right);
        for(String s: right){
            StringBuilder sb = new StringBuilder(Integer.toString(root.val));
            sb.append("->");
            sb.append(s);
            res.add(sb.toString());
        }
        return res;
    }
}
