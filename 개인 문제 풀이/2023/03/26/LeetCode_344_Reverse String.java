/*
[아이디어]
양 방향에서 값을 swap하며 들어왔다.

전위 연산자를 사용할 때, 후위 연산자를 사용할 때보다 속도와 메모리 측면에서 성능이 좋았다.
*/

class Solution {
    public void reverseString(char[] s) {
        int start = 0, end = s.length - 1;
        while(start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            ++start; --end;
        }
    }
}
