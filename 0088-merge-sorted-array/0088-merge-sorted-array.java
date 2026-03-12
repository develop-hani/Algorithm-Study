class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pt1 = m - 1;
        int pt2 = n - 1;
        int idx = m + n - 1;
    
        while (pt1 > -1 && pt2 > -1) {
            int a = nums1[pt1];
            int b = nums2[pt2];

            if (a > b) {
                nums1[idx--] = a;
                pt1 -= 1;
            } else {
                nums1[idx--] = b;
                pt2 -= 1;
            }
        }

        fillNum(nums1, idx, nums1, pt1);
        fillNum(nums1, idx, nums2, pt2);
    }

    private void fillNum(int[] nums1, int num1Idx, int[] arr, int pt) {
        while (pt > -1) {
            nums1[num1Idx--] = arr[pt--];
        }
    }
}