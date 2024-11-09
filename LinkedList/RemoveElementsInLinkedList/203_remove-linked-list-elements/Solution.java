/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode cur = dummyNode.next;
        ListNode pre = dummyNode;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                cur.next = null;
                cur = pre.next;
            } else {
                pre = cur;
                cur = pre.next;
            }
        }
        return dummyNode.next;
    }

//    public ListNode removeElements(ListNode head, int val) {
//        // 设置一个虚拟的头结点
//        ListNode dummy = new ListNode();
//        dummy.next = head;
//
//        ListNode cur = dummy;
//        while (cur.next != null) {
//            if (cur.next.val == val) {
//                cur.next = cur.next.next;
//            } else {
//                cur = cur.next;
//            }
//        }
//        return dummy.next;
//    }
}
