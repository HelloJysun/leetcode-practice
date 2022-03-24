package com.jysun.practice.computer;

import java.util.*;

/**
 * @author jysun
 * @since 2022/3/9
 */
public class HW {

    /**
     * 小明忘了密码，但小明记得密码的组合，并且知道组合中至少有几个数字命中
     * 举例：密码组合：[3,6,2,0]，至少有3个数字命中
     * 那么有效密码组合有
     * 0 2 3
     * 0 2 6
     * 0 3 6
     * 2 3 6
     * 0 2 3 6
     * 注意排序：相同长度数字从小到达排列
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String arr = in.next();
            String[] data = arr.split(",");
            data = Arrays.stream(data).distinct().sorted().toArray(String[]::new);
            int n = in.nextInt();
            if (n > data.length) {
                System.out.println("None");
                continue;
            }
            // 组合解法。其中长度大于等于n都可
            boolean[] visited = new boolean[data.length];
            List<String> list = new ArrayList<>();
            for (int i = n; i <= data.length; i++) {
                solution(data, visited, new StringBuilder(), i, list, 0);
            }
            list.sort(String::compareTo);
            for (String s : list) {
                String[] ss = s.split("");
                for (int i = 0; i < ss.length - 1; i++) {
                    System.out.print(ss[i] + ",");
                }
                System.out.println(ss[ss.length - 1]);
            }
        }
    }

    private static void solution(String[] data, boolean[] visited, StringBuilder res, int n, List<String> list,int k) {
        if (res.length() >= n) {
            list.add(res.toString());
            return;
        }
        for (int j = k; j < data.length; j++) {
            if (visited[j]) {
                continue;
            }
            visited[j] = true;
            res.append(data[j]);
            solution(data, visited, res, n, list, j);
            res.deleteCharAt(res.length() - 1);
            visited[j] = false;
        }
    }

    /**
     *
     */
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {
//            int len1 = in.nextInt();
//            int[] array1 = new int[len1];
//            for (int i = 0; i < len1; i++) {
//                array1[i] = in.nextInt();
//            }
//            int len2 = in.nextInt();
//            int[] array2 = new int[len2];
//            for (int i = 0; i < len2; i++) {
//                array2[i] = in.nextInt();
//            }
//            int k = in.nextInt();
//            List<Integer> list = new ArrayList<>();
//            for (int i1 : array1) {
//                for (int i2 : array2) {
//                    list.add(i1 + i2);
//                }
//            }
//            list.sort(Integer::compareTo);
//            int res = 0, i = 0;
//            while (k-- > 0) {
//                res += list.get(i++);
//            }
//            System.out.println(res);
//        }
//    }
}
