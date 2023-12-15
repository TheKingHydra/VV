package fr.istic.vv;


import java.util.LinkedList;

public class StringUtils {

    private StringUtils() {}

    /**
     * A string containing grouping symbols {}[]() is said to be balanced if every open symbol {[( has a matching closed symbol ]} and the substrings before, after and between each pair of symbols is also balanced. The empty string is considered as balanced.
     * For example: {[][]}({}) is balanced, while ][, ([)], {, {(}{} are not.
     * @param str the string to test
     * @return true if the string is balanced, false otherwise
     */
    public static boolean isBalanced(String str) {
        LinkedList<Character> list = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            switch (c) {
                case '{':
                    list.push('}');
                    break;
                case '[':
                    list.push(']');
                    break;
                case '(':
                    list.push(')');
                    break;
                default:
                    if (list.isEmpty() || list.pop() != c) {
                        return false;
                    }
            }
        }
        return list.isEmpty();
    }
}
