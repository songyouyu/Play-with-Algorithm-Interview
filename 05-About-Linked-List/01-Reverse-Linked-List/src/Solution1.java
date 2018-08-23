/**
 * leetcode 206
 * @author youyusong
 * @date 2018/8/22
 */
public class Solution1 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            // 将cur指向next的指针指向pre
            cur.next = pre;
            pre = cur;
            cur = next;

        }
        return pre;
    }
}
