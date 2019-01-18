/**
 * leetcode 203
 * @author youyusong
 * @date 2018/8/23
 */
public class Solution1 {

    public ListNode removeElements(ListNode head, int val) {

        // 处理头节点
        while (head.next != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }

        if (head == null) {
            return null;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == val) {
                ListNode delNode = cur.next;
                cur.next = delNode.next;
                delNode.next = null;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

}
