package com.jysun.practice.offer;

/**
 * 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 *
 * 示例 1：
 * 输入：[3,4,5,1,2]
 * 输出：1
 *
 * 示例 2：
 * 输入：[2,2,2,0,1]
 * 输出：0
 *
 * @author json
 * @since 2021/8/14
 */
public class Offer11 {

    public static void main(String[] args) {
        Offer11 obj = new Offer11();
        int[] nums1 = {3, 4, 5, 1, 2};
        int[] nums2 = {2, 2, 0, 0, 1};
        int[] nums3 = {4, 5, 0, 1, 2, 3};
        int[] nums4 = {3,3,1,3};
        System.out.println(obj.minArray(nums1));
        System.out.println(obj.minArray(nums2));
        System.out.println(obj.minArrayOpt(nums1));
        System.out.println(obj.minArrayOpt(nums2));
        System.out.println(obj.minArrayOpt(nums3));
        System.out.println(obj.minArrayOpt(nums4));
    }

    public int minArray(int[] numbers) {
        int init = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < init) {
                return numbers[i];
            }
        }
        return init;
    }

    public int minArrayOpt(int[] numbers) {
        int lo = 0, hi = numbers.length - 1;
        while (lo < hi) {
            int mid = lo + hi >> 1;
            // mid - hi有序
            if (numbers[mid] < numbers[hi]) {
                hi = mid;
            } else if (numbers[mid] > numbers[hi]){ // 最小数在右侧
                lo = mid + 1;
            } else { // 中间元素和最右侧相等
                hi--;
            }
        }
        return numbers[lo];
    }
}
