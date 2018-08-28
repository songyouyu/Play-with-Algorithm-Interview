import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 77
 * @author youyusong
 * @date 2018/8/28
 */
public class Solution {

    private ArrayList<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        if (n < 0 || k < 0 || k > n) {
            return res;
        }

        LinkedList<Integer> c = new LinkedList<>();
        generateCombinations(n ,k , 1, c);
        return res;
    }


    private void generateCombinations(int n, int k, int start, LinkedList<Integer> c){
       if (c.size() == k) {
           res.add((LinkedList<Integer>)c.clone());
       }

       for (int i = 1; i <= n; i ++) {
           c.addLast(i);
           generateCombinations(n, k, i + 1, c);
           c.removeLast();
       }
       return;
    }
}
