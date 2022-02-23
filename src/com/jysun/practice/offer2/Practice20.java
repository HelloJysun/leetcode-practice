package com.jysun.practice.offer2;

import java.util.HashMap;
import java.util.Map;

/**
 * 表示数值的字符串
 *
 * @author jysun
 * @since 2022/2/21
 */
public class Practice20 {
    public static void main(String[] args) {
        System.out.println(new Practice20().isNumber(".3."));
    }

    enum CharType {
        // 字符类型分为数字、科学计数法符号、小数点、正负符号、空格、非法字符
        NUMBER, EXP, POINT, SIGN, SPACE, ILLEGAL
    }

    enum Node {
        // 节点分为空格开始，数值符号位，数值，小数点，无前置数值小数点，小数数值，指数位，指数符号位，指数数值，空格
        SPACE_START, NUMBER_SIGN, NUMBER, DECIMAL_POINT, DECIMAL_POINT_WITHOUT_NUMBER, DECIMAL_NUMBER, EXP, EXP_SIGN, EXP_NUMBER, SPACE_END
    }

    public CharType toCharType(char ch) {
        if (ch >= '0' && ch <= '9') {
            return CharType.NUMBER;
        } else if (ch == 'e' || ch == 'E') {
            return CharType.EXP;
        } else if (ch == '.') {
            return CharType.POINT;
        } else if (ch == '+' || ch == '-') {
            return CharType.SIGN;
        } else if (ch == ' ') {
            return CharType.SPACE;
        } else {
            return CharType.ILLEGAL;
        }
    }

    /**
     * 题目所给 3. 这种也算做小数
     * 空格、数值符号位、数值、小数点、小数位、e/E、指数符号位、指数数值、空格
     * 小数分为小数点前有数值和没数值两种情况
     */
    public boolean isNumber(String s) {
        // 排列组合出上述每个节点后续所能跟的字符类型，状态机核心
        Map<Node, Map<CharType, Node>> transfer = new HashMap<>();
        // 首节点可以为空格、符号位、数值、小数点
        Map<CharType, Node> startMap = new HashMap<CharType, Node>() {{
            put(CharType.SPACE, Node.SPACE_START);
            put(CharType.SIGN, Node.NUMBER_SIGN);
            put(CharType.NUMBER, Node.NUMBER);
            put(CharType.POINT, Node.DECIMAL_POINT_WITHOUT_NUMBER);
        }};
        transfer.put(Node.SPACE_START, startMap);
        // 符号位后可以为数值、无前置数值小数点
        Map<CharType, Node> signMap = new HashMap<CharType, Node>() {{
            put(CharType.NUMBER, Node.NUMBER);
            put(CharType.POINT, Node.DECIMAL_POINT_WITHOUT_NUMBER);
        }};
        transfer.put(Node.NUMBER_SIGN, signMap);
        // 数值后边可以为数值、小数点、指数位、空格结束
        Map<CharType, Node> numberMap = new HashMap<CharType, Node>() {{
            put(CharType.NUMBER, Node.NUMBER);
            put(CharType.POINT, Node.DECIMAL_POINT);
            put(CharType.EXP, Node.EXP);
            put(CharType.SPACE, Node.SPACE_END);
        }};
        transfer.put(Node.NUMBER, numberMap);
        // 小数点后可以为小数点数值
        Map<CharType, Node> pointMap = new HashMap<CharType, Node>() {{
            put(CharType.NUMBER, Node.DECIMAL_NUMBER);
            put(CharType.EXP, Node.EXP);
            put(CharType.SPACE, Node.SPACE_END);
        }};
        transfer.put(Node.DECIMAL_POINT, pointMap);
        // 小数点数值后可以为小数点数值、指数位、空格结束
        Map<CharType, Node> decimalNumberMap = new HashMap<CharType, Node>() {{
            put(CharType.NUMBER, Node.DECIMAL_NUMBER);
            put(CharType.EXP, Node.EXP);
            put(CharType.SPACE, Node.SPACE_END);
        }};
        transfer.put(Node.DECIMAL_NUMBER, decimalNumberMap);
        // 无前置数值的小数点后可以为数值
        Map<CharType, Node> pointWithoutNumberMap = new HashMap<CharType, Node>() {{
            put(CharType.NUMBER, Node.DECIMAL_NUMBER);
        }};
        transfer.put(Node.DECIMAL_POINT_WITHOUT_NUMBER, pointWithoutNumberMap);
        // 指数后可以为指数数值、指数符号位
        Map<CharType, Node> expMap = new HashMap<CharType, Node>() {{
            put(CharType.NUMBER, Node.EXP_NUMBER);
            put(CharType.SIGN, Node.EXP_SIGN);
        }};
        transfer.put(Node.EXP, expMap);
        // 指数符号位后可以为指数数值
        Map<CharType, Node> expSignMap = new HashMap<CharType, Node>() {{
            put(CharType.NUMBER, Node.EXP_NUMBER);
        }};
        transfer.put(Node.EXP_SIGN, expSignMap);
        // 指数数值后可以为指数数值、空格结束
        Map<CharType, Node> expNumberMap = new HashMap<CharType, Node>() {{
            put(CharType.NUMBER, Node.EXP_NUMBER);
            put(CharType.SPACE, Node.SPACE_END);
        }};
        transfer.put(Node.EXP_NUMBER, expNumberMap);
        // 空格结束后可以为空格结束
        Map<CharType, Node> endMap = new HashMap<CharType, Node>() {{
            put(CharType.SPACE, Node.SPACE_END);
        }};
        transfer.put(Node.SPACE_END, endMap);

        Node node = Node.SPACE_START;
        for (char c : s.toCharArray()) {
            CharType charType = toCharType(c);
            Map<CharType, Node> next = transfer.get(node);
            if (!next.containsKey(charType)) {
                return false;
            } else {
                node = next.get(charType);
            }
        }
        // 标志一个数结束可以是空格、指数数值、数值、小数点、小数点数值
        return node == Node.SPACE_END || node == Node.NUMBER || node == Node.EXP_NUMBER || node == Node.DECIMAL_POINT || node == Node.DECIMAL_NUMBER;
    }
}
