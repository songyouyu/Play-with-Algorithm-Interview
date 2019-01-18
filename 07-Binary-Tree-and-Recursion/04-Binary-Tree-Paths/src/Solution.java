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
        ArrayList<String> res = new ArrayList<>();

        // 递归的终止条件
        if (root == null) {
            return res;
        }

        if (root.left == null && root.right == null) {
            res.add(Integer.toString(root.val));
            return res;
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

    public static void main(String[] args) {
        Solution.TreeNode p = new Solution(). new TreeNode(1);
        p.left = new Solution().new TreeNode(2);
        p.right = new Solution().new TreeNode(3);

        Solution solution = new Solution();
        List<String> paths = solution.binaryTreePaths(p);
        System.out.println(paths);


    }
}
