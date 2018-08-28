import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 46
 * @author youyusong
 * @date 2018/8/28
 */
public class Solution {

    private ArrayList<List<Integer>> res;

    private boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        visited = new boolean[nums.length];
        LinkedList<Integer> p = new LinkedList<>();
        generatePermutation(nums, 0, p);

        return res;
    }

    private void generatePermutation(int[] nums, int index, LinkedList<Integer> p){
        if ( index == nums.length ) {
            res.add((LinkedList<Integer>)p.clone());
            return;
        }

        for (int i = 0; i < nums.length; i ++) {
            if (! visited[i]) {
                p.addLast(nums[i]);
                visited[i] = true;
                generatePermutation(nums, index + 1, p);
                p.removeLast();
                visited[i] = false;
            }
        }
        return;
    }
}

