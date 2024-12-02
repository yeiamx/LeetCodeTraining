/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head; ListNode slow = head;
        while (fast != null && slow != null) {
            fast = fast.next;
            if (fast == null) return null;
            fast = fast.next;
            slow = slow.next;

            if (slow != null && fast == slow) {
                ListNode index1 = head; ListNode index2 = fast;
                while (index1 != index2) {
                    index1 = index1.next; index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }

    class ListNode {
        // 结点的值
        int val;

        // 下一个结点
        ListNode next;

        // 节点的构造函数(无参)
        public ListNode() {
        }

        // 节点的构造函数(有一个参数)
        public ListNode(int val) {
            this.val = val;
        }

        // 节点的构造函数(有两个参数)
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
