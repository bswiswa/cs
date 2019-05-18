#| Calculator function as a lesson on working with deep lists

(+ (* 3 4) (* 5 (+ 6 7)))
The expression here can be viewed as data composed of a list of lists of lists
This will help us build up to looking at a Scheme interpreter. This interpreter will be simplified to fewer functions
There are 3 pieces to an interpreter:
1. The read-eval-print loop (REPL) - it is a loop that runs forever

(define (calc)
  (display "calc: ")
  (flush)
  (print (calc-eval (read)))
  (calc))

- it is a loop because at the end it has a tail call to itself
- the read-eval-print aspect is because of the line (print (calc-eval (read))) which in Scheme first calls the read procedure whose job is to turn things with parantheses into pairs. The result of read is given to calc-eval which is the evaluator and it takes an expression as its argument and returns the value of that expression and then the print function displays that result of evaluation.

2. Evaluate an expression
(define (calc-eval exp)
  (cond ((number? exp) exp)
	((list? exp) (calc-apply (car exp) (map calc-eval (cdr exp))))
	(else (error "Calc: bad expression: " exp)) ))

There are basically 4 kinds of expressions in Scheme:
- self-evaluating eg numbers, booleans
- variables -> not in the calculator to limit complexity
- function calls -> limited to 4 functions in the calculator
- special forms -> not in our training interpreter but in an actual interpreter a lot of the complexity goes into the special forms in eval

For our calculator every list is a procedure call.
The evaluator is at the heart of every interpretor because it takes in the user input and figures out what it means. An evaluator for a language like Java is very complicated because there are numerous possible inputs and they also vary by context.
In Lisp interpreter eval is much simpler because one complete expression is one list so the form of the expressions matches the form of the data that the language knows how to deal with. (xx(xxx(xxx))). The Lisp language was designed in such a form as to be able to evaluate its own programs very straight-forwardly.
Lispians say that at the heart of every programming language is a Lisp interpreter trying to get out because you always have to evaluate expressions that are mostly procedure calls. It's just that there is a lot of syntax in the way of doing that but in Scheme the syntax doesn't get in the way.

Syntax = the technical terms / what the program looks like
Semantics = what the program means/ what it is trying to do
|#
