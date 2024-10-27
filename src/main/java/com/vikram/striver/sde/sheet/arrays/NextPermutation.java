package com.vikram.striver.sde.sheet.arrays;

import java.util.ArrayList;
import java.util.List;

public class NextPermutation {
    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(new int[] {1,2,3});
    }

    // 2. Optimal solution
    public void nextPermutation2(int[] nums) {
        int n = nums.length;
        //find index where  it is small
        int index = -1;
        for (int i = n-2; i>=0 ; i--) {
            if (nums[i] < nums[i+1]) {
                index = i;
                break;
            }
        }
        //if index not found , means number is last (biggest), return 1st
        if (index == -1) {
            reverse(nums,0,n-1);
        } else {
            //find index from end where it is just big than earlier index, swap
            for (int i = n-1; i>index ; i--) {
                if (nums[i] > nums[index]) {
                    int temp = nums[i];
                    nums[i] = nums[index];
                    nums[index] = temp;
                    break;
                }
            }
            //then reverse end part
            reverse(nums,index+1,n-1);
        }
    }

    private void reverse(int[] nums, int start, int end) {
        for (int i = start, j = end; i < j ; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    // 1. Naive / BruteForce
    public void nextPermutation(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        permuteAllRecursive(0, nums, resultList, new ArrayList<>());
        resultList.forEach(System.out::println);
        //sort & find number and print next, if last print first
    }

    private void permuteAllRecursive
            (int index, int[] nums, List<List<Integer>> resultList, List<Integer> current) {
        if (index == nums.length) {
            resultList.add(new ArrayList<>(current));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            current.add(nums[index]);
            permuteAllRecursive(index+1, nums, resultList, current);
            current.remove(current.size()-1);
            swap(nums, i, index);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
