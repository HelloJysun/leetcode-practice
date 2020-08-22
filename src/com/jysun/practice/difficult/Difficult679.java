package com.jysun.practice.difficult;

/**
 * @author Jysun
 * @description 24 点游戏
 * 你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过 *，/，+，-，(，) 的运算得到 24。
 *
 * 示例 1:
 *
 * 输入: [4, 1, 8, 7]
 * 输出: True
 * 解释: (8-4) * (7-1) = 24
 * 示例 2:
 *
 * 输入: [1, 2, 1, 2]
 * 输出: False
 * 注意:
 *
 * 除法运算符 / 表示实数除法，而不是整数除法。例如 4 / (1 - 2/3) = 12 。
 * 每个运算符对两个数进行运算。特别是我们不能用 - 作为一元运算符。例如，[1, 1, 1, 1] 作为输入时，表达式 -1 - 1 - 1 - 1 是不允许的。
 * 你不能将数字连接在一起。例如，输入为 [1, 2, 1, 2] 时，不能写成 12 + 12 。
 *
 * @date 2020/8/22 10:14
 */
public class Difficult679 {

    public static void main(String[] args) {
        Difficult679 obj = new Difficult679();
        System.out.println(obj.judgePoint24(new int[]{4, 1, 8, 7}));
        System.out.println(obj.judgePoint24(new int[]{1, 2, 1, 2}));
    }

    /**
     * 穷举！穷举！穷举
     *
     * @param nums
     * @return
     */
    public boolean judgePoint24(int[] nums) {
        double a = nums[0];
        double b = nums[1];
        double c = nums[2];
        double d = nums[3];
        return judge(a, b, c, d);
    }

    /**
     * 加法、乘法具有交换性
     *
     * @param a
     * @param b
     * @param c
     * @param d
     * @return
     */
    private boolean judge(double a, double b, double c, double d) {
        return
                // a b
                judge(a + b, c, d) ||
                        judge(a * b, c, d) ||
                        judge(a - b, c, d) ||
                        judge(b - a, c, d) ||
                        judge(a / b, c, d) ||
                        judge(b / a, c, d) ||
                        // b c
                        judge(c + b, a, d) ||
                        judge(c * b, a, d) ||
                        judge(c - b, a, d) ||
                        judge(b - c, a, d) ||
                        judge(c / b, a, d) ||
                        judge(b / c, a, d) ||
                        // c d
                        judge(c + d, a, b) ||
                        judge(c * d, a, b) ||
                        judge(c - d, a, b) ||
                        judge(d - c, a, b) ||
                        judge(c / d, a, b) ||
                        judge(d / c, a, b) ||
                        // b d
                        judge(b + d, a, c) ||
                        judge(b * d, a, c) ||
                        judge(b - d, a, c) ||
                        judge(d - b, a, c) ||
                        judge(b / d, a, c) ||
                        judge(d / b, a, c) ||
                        // a c
                        judge(a + c, b, d) ||
                        judge(a * c, b, d) ||
                        judge(a - c, b, d) ||
                        judge(c - a, b, d) ||
                        judge(a / c, b, d) ||
                        judge(c / a, b, d) ||
                        // a d
                        judge(a + d, b, c) ||
                        judge(a * d, b, c) ||
                        judge(a - d, b, c) ||
                        judge(d - a, b, c) ||
                        judge(a / d, b, c) ||
                        judge(d / a, b, c) ;
    }

    private boolean judge(double a, double b, double c) {
        return
                judge(a + b, c) ||
                        judge(a * b, c) ||
                        judge(a - b, c) ||
                        judge(b - a, c) ||
                        judge(a / b, c) ||
                        judge(b / a, c) ||
                        //
                        judge(c + b, a) ||
                        judge(c * b, a) ||
                        judge(c - b, a) ||
                        judge(b - c, a) ||
                        judge(c / b, a) ||
                        judge(b / c, a) ||
                        //
                        judge(c + a, b) ||
                        judge(c * a, b) ||
                        judge(c - a, b) ||
                        judge(a - c, b) ||
                        judge(c / a, b) ||
                        judge(a / c, b);
    }

    private boolean judge(double a, double b) {
        return Math.abs(a + b - 24) < 1e-6 ||
                Math.abs(a * b - 24) < 1e-6 ||
                Math.abs(a - b - 24) < 1e-6 ||
                Math.abs(b - a - 24) < 1e-6 ||
                Math.abs(a / b - 24) < 1e-6 ||
                Math.abs(b / a - 24) < 1e-6;
    }

}
