/* *****************************************************************************
 *  Name:              Batsi Swiswa
 *  Last modified:     2020
 **************************************************************************** */
/// 1.3.4

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Parentheses {
    private static String check(String str) {
        Stack<Character> s = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            if ("([{".indexOf(current) != -1)
                s.push(current);
            if (")]}".indexOf(current) != -1) {
                if (s.isEmpty()) return "false";
                char match = s.pop();
                if ((current == ')' && match != '(') ||
                        (current == ']' && match != '[') ||
                        (current == '}' && match != '{'))
                    return "false";
            }
        }

        if (s.isEmpty()) return "true";
        return "false"; // never reached
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            StdOut.println("Usage: java-algs4 Parentheses text");
            return;
        }
        StdOut.println(check(args[0]));
    }
}
