; Higher Order functions
; given the two functions below
(define (sumsquare a b)
  (if (> a b)
      0
      (+ (* a a) (sumsquare (+ a 1) b)) ))
(define (sumcube a b)
  (if (> a b)
      0
      (+ (* a a a)  (sumcube (+ a 1) b)) ))
; how can we capture this behaviour under one function?
(define (sum fn a b)
  (if (> a b)
      0
      (+ (fn a) (sum fn (+ a 1) b)) ))

; given the two functions below
(define (evens nums)
  (
   cond((empty? nums) '())
       ((equal? (remainder (first nums) 2) 0) (se (first nums) (evens (bf nums))))
       (else (evens (bf nums))) ))

(define (ewords str)
  (
   cond((empty? str) '())
       ((member? 'e (first str)) (se (first str) (ewords (bf str))))
       (else (ewords (bf str)))
))

; how can we write a higher order function that captures them both
(define (keep pred str)
  (
   cond((empty? str) '())
       ((pred (first str)) (se (first str) (keep pred (bf str))))
       (else (keep pred (bf str)))
))

; all we have to do is to define the given predicate (pred) to supply eg:
(define (eward? w)(member? 'e w))

#| if you do not want to predefine the predicates you can also use a lambda function during the function call eg
(keep (lambda(w) (member? 'e w)) '(here are my words))

which would return
(here are)

Lambdas can be used as arguments to higher order function.
|#

#| A higher order function can take a procedure as an argument and can also return a function eg a derivative or an integral.
Generalizing patterns helps to reduce the number of programs that we write over and over. The more functions we have the harder it is to understand. So generalizing patterns are a way to minimize the length, repetition and complexity of programs.

		    