/*
[아이디어]
입력으로 주어진 numbers가 정렬되어 있다는 점을 활용해 두 수의 합과 target을 비교하였다.
*/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int left = 0, right = numbers.length - 1;

        int sum = numbers[left] + numbers[right];
        while(sum != target) {
            if(sum > target) right--; 
            else left++;
            
            sum = numbers[left] + numbers[right];
        }
        ans[0] = left + 1;
        ans[1] = right + 1;
        return ans;
    }
}
