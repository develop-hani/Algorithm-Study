class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxIdx = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (maxIdx < i) return false;
            maxIdx = Math.max(maxIdx, i + nums[i]);
            if (reachable(n - 1, maxIdx)) return true;
            // System.out.println("i : " + i + " maxIdx : " + maxIdx + " arr[i] : " + nums[i]);
        }

        return reachable(n - 1, maxIdx);
    }

    private boolean reachable(int dest, int idx) {
        if (idx < dest) return false;
        return true;
    }
}