class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> digits = new ArrayList<>();

        for (int i = 0; i < nums.length; ++i) {
            int num = nums[i];
            List<Integer> ch = String.valueOf(num).chars().map(c -> c -'0').boxed().toList();
            digits.addAll(ch);
        }

        return digits.stream().mapToInt(Integer::intValue).toArray();
    }
}