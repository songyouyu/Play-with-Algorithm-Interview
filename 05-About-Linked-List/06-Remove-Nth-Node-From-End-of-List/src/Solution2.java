/**
 * leetcode 19
 * @author youyusong
 * @date 2018/8/25
 */
public class Solution2 {

    /**
     * 双指针
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode p = dummyHead;
        ListNode q = dummyHead;

        for (int i = 0; i < n + 1; i ++) {
            q = q.next;
        }

        // 循环结束后,此时 p 指向待删除节点的前一个节点
        while (q != null) {
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;

        return dummyHead.next;
    }

}
