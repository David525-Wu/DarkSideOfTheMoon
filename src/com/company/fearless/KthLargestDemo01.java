package com.company.fearless;

import java.util.Random;

public class KthLargestDemo01 {
    public int findKthLargest(int[] nums, int k) {
        Random random = new Random();

        int left = 0, right = nums.length - 1;
        while (true) {
            int pos = partition(nums, left, right, random);
            if (pos == k - 1) {
                return nums[pos];
            } else if (pos > k - 1) {
                right = pos - 1;
            } else {
                left = pos + 1;
            }
        }
    }

    private int partition(int[] nums, int left, int right, Random random) {
        int pivotIdx = left + random.nextInt(right - left + 1);
        int pivot = nums[pivotIdx];
        swap(nums, pivotIdx, right);
        int storeIdx = left;
        for (int i = left; i < right; i++) {
            if (nums[i] > pivot) { // 注意这里是降序
                swap(nums, storeIdx, i);
                storeIdx++;
            }
        }
        swap(nums, storeIdx, right);
        return storeIdx;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(new KthLargestDemo01().findKthLargest(nums, k)); // 输出：5
    }
}
