/* *****************************************************************************
 *  Name:              Batsi Swiswa
 *  Last modified:     2020
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/// 1.3.9
/*
    Write a program that takes from standard input an expression without left parentheses
    and prints the equivalent infix expression with the parentheses inserted. For example
     given the input 1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )
     your program should print ( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )
 */
public class Parentheses2 {
    public static String getParenthesizedInfix(String e) {
        // split the expression into clauses eg 1 + 2 ) and intermediate operators
        int opCount = 0;
        zQueue<String> opQ = new zQueue<String>();
        zQueue<String> clauseQ = new zQueue<String>();
        String tmp = "";
        for (int i = e.length() - 1; i >= 0; i--) {
            char current = e.charAt(i);
            if ("-+*/%".indexOf(current) != -1) opCount++;
            if (opCount > 0 && opCount % 2 == 0) {
                clauseQ.enqueue(tmp.trim());
                tmp = "";
                opQ.enqueue(" " + current + " ");
                opCount = 0;
            }
            else if (i == 0) {
                tmp = (Character.toString(current)).concat(tmp);
                clauseQ.enqueue(tmp.trim());
            }
            else {
                tmp = (Character.toString(current)).concat(tmp);
            }
        }
        tmp = "";
        boolean doubleBracket = false;
        int clauseCount = clauseQ.size();
        int doubleBracketCount = 0;
        for (int i = 0; i < clauseCount; i++) {
            String currentClause = clauseQ.dequeue();
            int dbcount = -1;
            for (int j = 0; j < currentClause.length(); j++)
                if (currentClause.charAt(j) == ')') dbcount++;
            if (dbcount > 0) {
                doubleBracketCount += dbcount;
                doubleBracket = false;
            }
            else doubleBracket = true;

            tmp = currentClause.concat(tmp);
            tmp = "( ".concat(tmp);
            if (doubleBracket && doubleBracketCount > 0) {
                tmp = "( ".concat(tmp);
                doubleBracketCount--;
            }
            if (!opQ.isEmpty())
                tmp = opQ.dequeue().concat(tmp);
        }
        return tmp;
    }

    public static void main(String[] args) {
        String e = "";
        while (e.length() == 0) {
            StdOut.println("Enter an expression such as 1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) ) :");
            e = StdIn.readLine();
        }
        StdOut.println(getParenthesizedInfix(e));

    }
}
