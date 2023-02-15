package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Problem227 {
    public int calculate(String s) {
        Deque<Character> symbol = new ArrayDeque<>();
        Deque<Integer> number = new ArrayDeque<>();
        for (int i = 0; i < s.length(); ++i) {
            if(Character.isSpaceChar(s.charAt(i)))
                continue;
            if (Character.isDigit(s.charAt(i))) {
                int p = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    p = p * 10 + Character.getNumericValue(s.charAt(i));
                    ++i;
                }
                i--;
                if (!symbol.isEmpty() && (symbol.getLast().equals('*') || symbol.getLast().equals('/'))) {
                    char sym = symbol.getLast();
                    if (sym == '*')
                        number.addLast(number.removeLast() * p);
                    else
                        number.addLast(number.removeLast() / p);
                    symbol.removeLast();
                } else {
                    number.addLast(p);
                }
            } else {
                symbol.addLast(s.charAt(i));
            }
        }
        while (!symbol.isEmpty()) {
            int v1 = number.removeFirst();
            int v2 = number.removeFirst();
            char sym = symbol.removeFirst();
            if(sym=='+')
                number.addFirst(v2+v1);
            else
                number.addFirst(v1-v2);
        }
        return number.getFirst();
    }
}
