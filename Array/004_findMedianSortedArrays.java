package Leetcode.Array;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m < n)
            return findMedianSortedArrays(nums2, nums1);
        if (n == 0)
            return ((double) nums1[(m - 1) / 2] + (double) nums1[m / 2]) / 2;

        int low = 0, high = n * 2;
        while (low <= high) {
            int mid2 = (low + high) / 2;
            int mid1 = (m + n) - mid2;

            double L1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2];
            double L2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2 - 1) / 2];
            double R1 = (mid1 == m * 2) ? Integer.MAX_VALUE : nums1[(mid1) / 2];
            double R2 = (mid2 == n * 2) ? Integer.MAX_VALUE : nums2[(mid2) / 2];

            if (L1 > R2)
                low = mid2 + 1;
            else if (L2 > R1)
                high = mid2 - 1;
            else
                return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
        }
        return -1;
    }
}