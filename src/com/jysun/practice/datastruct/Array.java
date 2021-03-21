package com.jysun.practice.datastruct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author Jysun
 * @description 随机生成数组 10以内
 * @date 2020/9/5 11:39
 */
public class Array {

    private Array() {
    }

    private static final int N = 10;

    public static int[] randomArr() {
        Random random = new Random();
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            res[i] = random.nextInt(N);
        }
        return res;
    }

    public static List<String> toString(int[][] matrix) {
        List<String> data = new ArrayList<>();
        for (int[] m : matrix) {
            data.add(Arrays.toString(m));
        }
        return data;
    }
}
