/**
 * leetcode 203
 * @author youyusong
 * @date 2018/8/23
 */
public class Solution2 {

    public ListNode removeElements(ListNode head, int val) {
        // 创建虚拟头节点
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode cur = dummyNode;

        while (cur.next != null) {
            if(cur.next.val == val ){
                ListNode delNode = cur.next;
                cur.next = delNode.next;
            } else {
                cur = cur.next;
            }
        }
        return dummyNode.next;
    }
}
