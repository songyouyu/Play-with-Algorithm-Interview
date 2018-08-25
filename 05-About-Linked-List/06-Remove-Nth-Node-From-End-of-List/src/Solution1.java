/**
 * leetcode 19
 * @author youyusong
 * @date 2018/8/25
 */
public class Solution1 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        int length = 0;
        for (ListNode cur = dummyHead.next; cur != null; cur = cur.next) {
            length ++;
        }

        int k = length - n;
        ListNode cur = dummyHead;
        // 循环结束时,cur 指向待删除节点的前一个节点
        for (int i = 0; i < k; i ++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummyHead.next;
    }

}
