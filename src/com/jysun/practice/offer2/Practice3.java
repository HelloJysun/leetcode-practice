package com.jysun.practice.offer2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 数组中重复的数字
 *
 * @author json
 * @since 2022/2/14
 */
public class Practice3 {
    public static void main(String[] args) {

    }

    /**
     * 哈希统计所有值，空间复杂度 O(N)，时间复杂度 O(N)
     */
    public int solution1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer cnt = map.getOrDefault(num, 0);
            map.put(num, cnt + 1);
        }
        for (Integer num : map.keySet()) {
            if (map.get(num) > 1) {
                return num;
            }
        }
        return -1;
    }

    /**
     * 长度为n的数组nums中数为0 ~ n-1
     * 所以直接用长度为nums.length的数组，下标即为元素值，遍历累加，只要有下标值为2直接返回
     * 空间复杂度 O(N)，时间复杂度 O(N)
     */
    public int solution2(int[] nums) {
        // 0到n-1
        int[] data = new int[nums.length];
        for (int num : nums) {
            if (data[num] == 1) {
                return num;
            }
            data[num] = data[num] + 1;
        }
        return -1;
    }

    /**
     * 排序后，比较先后俩元素相等就返回
     * 空间复杂度 O(1)，时间复杂度 O(NlogN)
     */
    public int solution3(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * 由于长度为n数组数值大小为0 ~ n-1
     * 所以可以将数值为n的数放到下标为n的位置，如果下标为n的位置已经和当前数相等就直接返回，否则就swap两个数，确保当前数放到下标为n位置
     */
    public int solution4(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // 这里之所以用while是为了防止，移动过来的元素刚好处于当前i位置
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
        }
        return -1;
    }

    /**
     * 如果是n个数字，值范围为1 ~ n-1 可用二分法统计
     */
    public int findRepeatNumber(int[] nums) {
        // 数字范围0 ~ n-1
        int min = 0, max = nums.length - 1;
        while (min < max) {
            int mid = min + max >> 1;
            int cnt = countRange(nums, min, mid);
            // 左侧统计值大于数，说明在左侧
            if (cnt > mid - min + 1) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        // min = max跳出返回一个即可
        return min;
    }

    public int countRange(int[] nums, int min, int max) {
        int cnt = 0;
        // 统计全数组中在min - max范围间的数目
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= min && nums[i] <= max) {
                cnt++;
            }
        }
        return cnt;
    }
}
