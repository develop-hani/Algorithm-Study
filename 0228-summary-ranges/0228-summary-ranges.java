class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();

        if (nums.length == 0) return ans;

        int start = nums[0];
        for (int i = 0; i < nums.length; ++i) {
            if (i == nums.length - 1) {
                ans.add(getStr(start, nums[i]));
                continue;
            }
            if (nums[i + 1] - nums[i] != 1) {
                ans.add(getStr(start, nums[i]));
                start = nums[i + 1];
            }
        }
        return ans;
    }

    private String getStr(int start, int end) {
        if (start == end) return String.valueOf(start);
        else return start + "->" + end;
    }
}