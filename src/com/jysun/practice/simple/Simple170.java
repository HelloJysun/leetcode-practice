package com.jysun.practice.simple;

import java.util.*;

/**
 * 设计并实现一个 TwoSum 的类，使该类需要支持 add 和 find 的操作。
 * <p>
 * add 操作 - 对内部数据结构增加一个数。
 * find 操作 - 寻找内部数据结构中是否存在一对整数，使得两数之和与给定的数相等。
 * 示例 1:
 * <p>
 * add(1); add(3); add(5);
 * find(4) -> true
 * find(7) -> false
 * 示例 2:
 * <p>
 * add(3); add(1); add(2);
 * find(3) -> true
 * find(6) -> false
 *
 * @author json
 * @since 2021/7/7
 */
public class Simple170 {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        twoSum.add(1);
        twoSum.add(1);
        twoSum.add(3);
        twoSum.add(5);
        System.out.println(twoSum.find(4));
        System.out.println(twoSum.find(7));
        System.out.println(twoSum.find(2));

        TwoSumOpt twoSumOpt = new TwoSumOpt();
        twoSumOpt.add(1);
        twoSumOpt.add(1);
        twoSumOpt.add(3);
        twoSumOpt.add(5);
        System.out.println(twoSumOpt.find(4));
        System.out.println(twoSumOpt.find(7));
        System.out.println(twoSumOpt.find(2));
    }

    static class TwoSum {
        // key：num - value：count
        Map<Integer, Integer> data;

        public TwoSum() {
            data = new HashMap<>();
        }

        public void add(int num) {
            data.put(num, data.getOrDefault(num, 0) + 1);
        }

        /**
         * 遍历所有数，寻找是否存在 target - num 的数
         * 这里考虑到重复数字情况，所以需要判断 count 是否也大于 1
         * @param target
         * @return
         */
        public boolean find(int target) {
            for (Integer num : data.keySet()) {
                if (target == num * 2 && data.get(num) > 1) {
                    return true;
                } else if (data.containsKey(target - num)) {
                    return true;
                }
            }
            return false;
        }
    }

    static class TwoSumOpt {
        // key：num - value：count
        Set<Integer> sum;
        List<Integer> data;

        public TwoSumOpt() {
            sum = new HashSet<>();
            data = new ArrayList<>();
        }

        /**
         * 添加进去的每个数都与现有的所有数做累加运算放进集合，判断是否存在 target - num 直接判断 target 是否在集合中即可
         * @param num
         */
        public void add(int num) {
            for (Integer i : data) {
                sum.add(i + num);
            }
            data.add(num);
        }

        public boolean find(int target) {
            return sum.contains(target);
        }
    }
}
