package BasicCalculator;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by donezio on 2/1/19.
 */
public class questions {

    public static abstract class myAB {
        public void foo () {
            System.out.println("foo");
        }
    }


    public static class Test extends myAB {

    }

    public static void main(String[] args) {
//        System.out.println(calculator1("1 + (2 - 6)"));
//        System.out.println(calculator2("2 + 3 * 4"));
//        System.out.println(calculator3("(2 + 3) * 4"));
//        List<String> res = addOps("105", 2);
//
//        res.forEach((a) -> System.out.println(a.substring(1)));



        Test t1 = new Test();
        t1.foo();
    }

    /*
        Only contains - + ( ), with arbitary spaces between them
        Eg: ( 2 +3 ) - (3 + 5)
        Algorithm : two stack, one for operator, one for operand
                    1. isDigit, using while to get Number, then push to number stack
                    2. ( push to operator stack
                    3. ) + -, process two stack, if ( ')' pop operarot) else push operator
     */

    public static int calculator1(String str) {
        Deque<Character> opStack = new LinkedList<>();
        Deque<Integer> numbers = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') continue;
            int num = 0;
            if (Character.isDigit(c)) {
                //int num = 0;
                while (i < str.length() && Character.isDigit(str.charAt(i))) {
                    num = num * 10 + (int)(str.charAt(i) - '0');
                    i +=1;
                }
                numbers.offerFirst(num);
                i--;
            }
            else if (c == '(') {
                opStack.offerFirst(c);
            } else {
                // (3+4-1)
                // computer previous result
                while (opStack.size()!= 0 && opStack.peekFirst() != '(') {
                    int num1 = numbers.pollFirst();
                    int num2 = numbers.pollFirst();
                    char op = opStack.pollFirst();
                    if (op == '+') {
                        numbers.offerFirst(num1 + num2);
                    } else {
                        numbers.offerFirst(num2 - num1);
                    }
                }
                if (c == ')') {
                    opStack.pollFirst();
                } else {
                    opStack.offerFirst(c);
                }
            }
        }
        // Process the rest
        while (opStack.size()!= 0 ) {
            int num1 = numbers.pollFirst();
            int num2 = numbers.pollFirst();
            char op = opStack.pollFirst();
            if (op == '+') {
                numbers.offerFirst(num1 + num2);
            } else {
                numbers.offerFirst(num2 - num1);
            }
        }
        return numbers.peekFirst();
    }
    /*
         same algorithm without * or /
         2 + 5 * 3
         algorithm 1 digit, if pre == + , prev == - push to stack, prev == *, prev == / pop from stack and compute then push
                   2 +, * , / -, change operator
     */
    public static int calculator2(String str) {
        char op = '+';
        Deque<Integer> nums = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ( c == ' ') continue;
            if (Character.isDigit(c)) {
                int num = 0;
                while ( i < str.length() && Character.isDigit(str.charAt(i))) {
                    num = num * 10 + (int) str.charAt(i) - '0';
                    i += 1;
                }
                i -= 1;

                if (op == '+') {
                    nums.offerFirst(num);
                }
                else if (op == '-') {
                    nums.offerFirst(-num);
                }
                else if (op == '*') {
                    nums.offerFirst(nums.pollFirst() * num);
                }
                else {
                    nums.offerFirst(nums.pollFirst() / num);
                }
            }
            else {
                op = c;
            }
        }
        int a = 1;
        return nums.stream().reduce(0, (x,y) -> x + y);
    }

    /*
        1 + ( 4 * 3 ) / 2
        if digit,     push to number stack
        if operator,  check precedence
     */

    static int getPrecedece(char c) {
        if (c == '*' || c == '/') return 2;
        return 1;
    }
    static public int calculator3(String str) {
        Deque<Character> ops = new LinkedList<>();
        Deque<Integer> numbers = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') continue;
            int num = 0;
            if (Character.isDigit(c)) {
                while (i < str.length() && Character.isDigit(str.charAt(i))) {
                    num = num * 10 + (int)(str.charAt(i) - '0');
                    i +=1;
                }
                numbers.offerFirst(num);
                i--;
            }
            else if (c == '(') {
                ops.offerFirst(c);
            }
            else if (c == ')') {
                while (ops.size() != 0 && ops.peekFirst() != '(') {
                    int num1 = numbers.pollFirst();
                    int num2 = numbers.pollFirst();
                    char op = ops.pollFirst();
                    if (op == '*') {
                        numbers.offerFirst(num1 * num2);
                    }
                    else if (op == '/'){
                        numbers.offerFirst(num1 / num2);
                    }
                    else if (op == '+') {
                        numbers.offerFirst(num1 + num2);
                    }
                    else {
                        numbers.offerFirst(num1 - num2);
                    }
                }
                // remove (
                ops.pollFirst();
            } else {
                while (ops.size() != 0 && getPrecedece(c) < getPrecedece(ops.peekFirst())) {
                    int num1 = numbers.pollFirst();
                    int num2 = numbers.pollFirst();
                    char op = ops.pollFirst();
                    if (op == '*') {
                        numbers.offerFirst(num1 * num2);
                    } else {
                        numbers.offerFirst(num1 / num2);
                    }
                }
                ops.offerFirst(c);
            }
        }
        while (ops.size() != 0 ) {
            int num1 = numbers.pollFirst();
            int num2 = numbers.pollFirst();
            char op = ops.pollFirst();
            if (op == '*') {
                numbers.offerFirst(num1 * num2);
            }
            else if (op == '/'){
                numbers.offerFirst(num1 / num2);
            }
            else if (op == '+') {
                numbers.offerFirst(num1 + num2);
            }
            else {
                numbers.offerFirst(num1 - num2);
            }
        }
        return numbers.peekFirst();
    }


    /*
        Expression add operator
        Given string that contains number and a target value, return all possibility expression to get target
        [123] target 6
         1 + 2 + 3 = 6
         1 * 2 * 3 = 6

         Algorithm use dfs
     */

    public static List<String> addOps(String str, int target) {
        List<String> res =  new ArrayList<>();
        helper(0, str, res, "", 0, 0 , target);
        return res;
    }

    public static void helper(int index, String str, List<String> res, String cur, int preAdd, int curVal, int target) {
        if (index == str.length()) {
            if (curVal == target) res.add(cur);
            return;
        }
        for (int i = index; i < str.length(); i++) {
            if (str.charAt(index) == '0') {
                helper(index + 1, str, res, cur + "+" + 0, 0, curVal, target);
                return;
            } else {
                int tmp = Integer.parseInt(str.substring(index, i + 1));
                helper(i + 1, str, res, cur + "+" + tmp, tmp, curVal + tmp, target);
                helper(i + 1, str, res, cur + "-" + tmp, -tmp, curVal - tmp, target);
                if (index != 0 && preAdd != 0) {
                    // * and /
                    helper(i + 1, str, res, cur + "*" + tmp, preAdd * tmp, curVal + preAdd * tmp - preAdd, target);
                    if(preAdd % tmp == 0) helper(i + 1, str, res, cur + "/" + tmp, preAdd / tmp, curVal + preAdd / tmp - preAdd, target);
                }
            }
        }
    }
}
