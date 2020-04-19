package com.jysun.practice.competition;

import java.util.*;

/**
 * @author Jysun
 * @description Week185
 * @date 2020/4/19 12:31
 */
public class Week185 {
    public static void main(String[] args) throws Exception {
        Week185 obj = new Week185();

        // 重新格式化字符串
        String s1 = "covid2019";
        String s2 = "a0b1c2";
        System.out.println(obj.reformat(s1));
        System.out.println(obj.reformat(s2));

        // 点菜展示表
        String[][] orders = {{"David", "3", "Ceviche"}, {"Corina", "10", "Beef Burrito"}, {"David", "3", "Fried Chicken"}, {"Carla", "5", "Water"}, {"Carla", "5", "Ceviche"}, {"Rous", "3", "Ceviche"}};
        List<List<String>> lists = new ArrayList<>();
        for (String[] order : orders) {
            lists.add(Arrays.asList(order));
        }
        System.out.println(obj.displayTable(lists));

        String croakOfFrogs = "crcroakoacrkoak";
        System.out.println(obj.minNumberOfFrogs(croakOfFrogs));
    }

    public String reformat(String s) {
        char[] chars = s.toCharArray();
        List<Character> nums = new ArrayList<>();
        List<Character> letters = new ArrayList<>();
        for (char a : chars) {
            if (a >= 'a' && a <= 'z') {
                letters.add(a);
            } else {
                nums.add(a);
            }
        }
        StringBuilder res = new StringBuilder();
        if (nums.size() - letters.size() == 1) { // 数字比字母多
            for (int i = 0; i < letters.size(); i++) {
                res.append(nums.get(i)).append(letters.get(i));
            }
            res.append(nums.get(nums.size() - 1));
        } else if (letters.size() - nums.size() == 1) { // 字母比数字多1
            for (int i = 0; i < nums.size(); i++) {
                res.append(letters.get(i)).append(nums.get(i));
            }
            res.append(letters.get(letters.size() - 1));
        } else if (nums.size() - letters.size() == 0) { // 字母数字相等
            for (int i = 0; i < letters.size(); i++) {
                res.append(nums.get(i)).append(letters.get(i));
            }
        } else {
            return "";
        }
        return res.toString();
    }


    public List<List<String>> displayTable(List<List<String>> orders) {
        Set<String> items = new TreeSet<>();
        Map<Integer, Map<String, Integer>> map = new TreeMap<>();
        for (List<String> order : orders) { // order 0姓名 1餐桌号 2点菜名
            items.add(order.get(2)); // 菜单名
            Integer tableNo = Integer.valueOf(order.get(1));
            if (map.containsKey(tableNo)) { // 已有餐桌
                Map<String, Integer> tableItems = map.get(tableNo);
                tableItems.put(order.get(2), tableItems.getOrDefault(order.get(2), 0) + 1);
            } else {
                Map<String, Integer> tableItems = new HashMap<>();
                tableItems.put(order.get(2), 1);
                map.put(tableNo, tableItems);
            }
        }
        List<List<String>> res = new ArrayList<>();
        List<String> itemList = new ArrayList<>();
        itemList.add("Table");
        for (String item : items) {
            itemList.add(item);
        }
        res.add(itemList);
        for (Map.Entry<Integer, Map<String, Integer>> entry : map.entrySet()) {
            List<String> tableItems = new ArrayList<>();
            tableItems.add(entry.getKey().toString());
            for (String item : items) {
                tableItems.add(entry.getValue().getOrDefault(item, 0).toString());
            }
            res.add(tableItems);
        }
        return res;
    }

    public int minNumberOfFrogs(String croakOfFrogs) {
        int c = 0;
        int r = 0;
        int o = 0;
        int a = 0;
        int k = 0;
        for (char ch : croakOfFrogs.toCharArray()) {
            if (ch == 'c') {
                c++;
            }
        }

        return 0;
    }
}
