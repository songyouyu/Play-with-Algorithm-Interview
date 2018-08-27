import javafx.util.Pair;

import java.util.*;

/**
 * leetcode 347
 * @author youyusong
 * @date 2018/8/27
 */
public class Solution {


    public List<Integer> topKFrequent(int[] nums, int k) {
        if (k < 0 || k > nums.length) {
            throw new IllegalArgumentException("exception");
        }

        // 统计每个元素出现的频率
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            if (! freq.containsKey(nums[i])) {
                freq.put(nums[i], 1);
            } else {
                freq.put(nums[i], freq.get(nums[i]) + 1);
            }
        }

        // 扫描freq,维护当前出现频率最高的k个元素
        // 优先队列中,按照频率排序,所以数据对是 (频率,元素) 的形式
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(new PairComparator());
        for (Integer num : freq.keySet()) {
            int value = freq.get(num);
            if (pq.size() == k) {
                if (value > pq.peek().getKey()) {
                    pq.poll();
                    pq.add(new Pair<>(value, num));
                }
            } else {
                pq.add(new Pair<>(value, num));
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (! pq.isEmpty()) {
            list.add(pq.poll().getValue());
        }
        return list;
    }

    private class PairComparator implements Comparator<Pair<Integer, Integer>> {
        @Override
        public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2){
            if(!p1.getKey().equals(p2.getKey())) {
                return p1.getKey() - p2.getKey();
            }
            return p1.getValue() - p2.getValue();
        }
    }
}
