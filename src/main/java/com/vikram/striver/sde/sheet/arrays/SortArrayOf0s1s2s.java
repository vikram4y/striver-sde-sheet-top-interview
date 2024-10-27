package com.vikram.striver.sde.sheet.arrays;

import java.util.Arrays;

public class SortArrayOf0s1s2s {
    public static void main(String[] args) {
        int arr[] = {2,0,2,1,1,0};
        SortArrayOf0s1s2s s = new SortArrayOf0s1s2s();
        s.sortArray(arr);
        System.out.println("Sorted = "+ Arrays.toString(arr));
    }

    // Optimal
    public void sortArray(int[] nums) {
        int start = 0;
        int mid = 0;
        int end = nums.length-1;
        while (mid <= end) {
            if (nums[mid] == 0) {
                swap(nums, start, mid);
                mid++;
                start++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, end);
                end--;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
