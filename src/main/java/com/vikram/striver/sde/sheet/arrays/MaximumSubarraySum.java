package com.vikram.striver.sde.sheet.arrays;

public class MaximumSubarraySum {
    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        MaximumSubarraySum maximumSubarraySum = new MaximumSubarraySum();
        System.out.println("Max = "+maximumSubarraySum.maxSubArray(arr));
    }

    // Optimal - Kadane's Algo
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum = Math.max(nums[i], sum+nums[i]);
            max = Math.max(max, sum);
        }
        return max;
    }
}
