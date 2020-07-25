import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/* *****************************************************************************
 *  Name:              Batsi Swiswa
 *  Last modified:     2020
 **************************************************************************** */
/// 1.3.10 Write a filter InfixToPostFix that converts an arithmetic expression
/// from infix to postfix
public class InfixToPostfix {
    public static String convert(String s) {
        // no operator precedence so relies on parentheses
        zStack<String> operandStk = new zStack<String>();
        zStack<String> operatorStk = new zStack<String>();
        String[] e = s.split("\\s");
        for (String x : e) {
            if (x.equals("(")) {
                continue;
            }
            else if ("+/*-%".contains(x))
                operatorStk.push(x);
            else if (x.equals(")")) {
                String operand2 = operandStk.pop();
                String operand1 = operandStk.pop();
                String operator = operatorStk.pop();
                operandStk.push(operand1 + " " + operand2 + " " + operator);
            }
            else operandStk.push(x);
        }
        return operandStk.pop();
        // handle operator precedence?? in the future

    }

    public static void main(String[] args) {
        StdOut.println("Enter an infix expression eg ((1 + 3) - 4 ) :");
        String s = StdIn.readLine();
        if (s.length() > 0)
            StdOut.println(convert(s));
    }
}
