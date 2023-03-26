/*
[아이디어]
0이 아닌 수들을 배열에 차례로 채워나갔다.
*/

import java.util.*;

class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int[] ans = new int[nums.length];

        for(int i = 0; i < nums.length; ++i) {
            if(nums[i] != 0) {
                ans[left++] = nums[i];
            }
        }

        for(int i = 0; i < nums.length; ++i) {
            nums[i] = ans[i];
        }
    }
}
