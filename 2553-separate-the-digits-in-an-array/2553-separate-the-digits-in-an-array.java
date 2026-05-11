class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> digits = new ArrayList<>();

        for (int i = nums.length - 1; i >= 0; --i) {
            int n = nums[i];

            while (n > 0) {
                digits.add(0, n % 10);
                n /= 10;
            }
        }

        return digits.stream().mapToInt(Integer::intValue).toArray();
    }
}