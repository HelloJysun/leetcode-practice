package com.jysun.practice.offer2;

/**
 * 在排序数组中查找数字 I
 *
 * @author json
 * @since 2022/3/15
 */
public class Practice53 {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(new Practice53().search(nums, 8));
        System.out.println(new Practice53().searchOpt1(nums, 8));
    }

    /**
     * 首先见到有序就是利用二分法特性
     * 二分法找到第一个小于target的下标l，找到第一个大于target的下标r
     * 长度就是r - l + 1
     */
    public int search(int[] nums, int target) {
        // 找左边界
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + right >> 1;
            // 找到相等的就收缩右边界
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] > target) {
                // 目标元素在[left, mid-1]
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        int leftIndex = left;
        // 找右边界
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + right >> 1;
            // 同理，找到相等的就收缩左边界
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return left - leftIndex;
    }

    /**
     * 从上边二分查找可以看出，nums[mid]和target不相等时的收缩边界操作都是一致的
     * 只有nums[mid]==target时在找左右边界时不同，找左边界时就收缩右边界right=mid-1，找右边界时就收缩左边界left=mid+1
     * 如果right右边界为数组长度-1，说明right可以访问，那while终止条件就是left > right
     */
    public int searchOpt1(int[] nums, int target) {
        // 找左边界
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + right >> 1;
            // 找到相等的就收缩右边界
            if (nums[mid] >= target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        int leftIndex = left;
        // 找右边界
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + right >> 1;
            // 同理，找到相等的就收缩左边界
            if (nums[mid] <= target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return left - leftIndex;
    }

}
