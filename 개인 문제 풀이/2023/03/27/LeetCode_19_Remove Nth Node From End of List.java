/*
[아이디어]
전체 node의 개수를 세고, 제거할 위치를 찾는다.
*/

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode ptr = head;

        while(ptr != null) {
            ++len;
            ptr = ptr.next;
        }

        ptr = head;
        int idx = len - n;
        System.out.println(len + " " + idx);

        if(idx == 0) { // next.next not available
            head = head.next;
        } else {
            for(int i = 1; i < idx; ++i) {
                ptr = ptr.next;
            }
            ptr.next = ptr.next.next;
        }

        return head;
    }
}
