class Solution {
    public boolean isPalindrome(int x) {
        int reverse = 0;
        int copy = x;
        while (copy > 0) {
            int num = copy % 10;
            copy /= 10;
            reverse = reverse * 10 + num;
        }
        return x == reverse;
    }
}