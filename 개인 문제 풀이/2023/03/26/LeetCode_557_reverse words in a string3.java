/*
[아이디어]
문자열을 띄어쓰기 단위로 문자열 배열로 바꾼 뒤, 각 문자열을 reverse하는 연산을 진행했다.
*/

import java.util.*;

class Solution {
    public String reverseWords(String s) {
        String[] str = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String word : str) {
            sb.append(reverse(word)).append(" ");
        }
        String ss = sb.toString();
        return ss.substring(0, ss.length() - 1);
    }

    private String reverse(String word) {
        char[] w = word.toCharArray();
        int start = 0, end = w.length - 1;
        while(start < end) {
            char tmp = w[start];
            w[start] = w[end];
            w[end] = tmp;
            ++start; --end;
        }
        return String.valueOf(w);
    }
}
