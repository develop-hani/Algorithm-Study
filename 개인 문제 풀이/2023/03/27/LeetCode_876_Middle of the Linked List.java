/*
[아이디어]
홀수 번째 node가 나타날때 뒤절반의 시작위치기 바뀐다.
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
    public ListNode middleNode(ListNode head) {
        ListNode start = head;
        int cur = 0;

        while(head != null) {
            if(cur++ % 2 == 1) start = start.next;
            head = head.next;
        }

        return start;
    }
}
