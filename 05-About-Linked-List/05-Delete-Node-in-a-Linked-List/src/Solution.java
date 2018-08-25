/**
 * leetcode 237
 * @author youyusong
 * @date 2018/8/25
 */
public class Solution {

    public void deleteNode(ListNode node) {
        // node 不是尾节点
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
