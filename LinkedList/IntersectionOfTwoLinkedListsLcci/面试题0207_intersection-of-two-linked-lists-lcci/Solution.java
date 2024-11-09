/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenLong = 0; int lenShort = 0;
        ListNode curA = headA; ListNode curB = headB;
        while (curA != null) {
            lenLong++;
            curA = curA.next;
        }
        while (curB != null) {
            lenShort++;
            curB = curB.next;
        }
        if (lenLong < lenShort) {
            int temp; ListNode tempListNode;
            temp = lenLong;
            lenLong = lenShort;
            lenShort = temp;
            tempListNode = headA;
            headA = headB;
            headB = tempListNode;
        }

        for (int i = 0; i < lenLong-lenShort; i++) {
            headA = headA.next;
        }

        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
