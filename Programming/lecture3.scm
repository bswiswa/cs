; Higher order functions
#| These are functions that can take other functions as input
for example the integral function
|#

(define pi 3.142)
; Here are 3 area functions
(define (circle-area r)(* pi r r))
(define (sphere-area r)(* 4 pi r r))
(define (hexagon-area r)(* (sqrt 3) 1.5 r r))

#| The pattern to note in all these is that all functions take in a 
value r and return a result of some constant X r^2. Instead of having to write all
3 functions as separate, we could create a single function that takes in the shape and 
the value then decides how to compute the area.
|#
(define sphereConst (* 4 pi))
(define hexagonConst (* (sqrt 3) 1.5 ))
(define (area shape r)(
		       cond ((equal? shape 'circle)(* pi r r))
			     ((equal? shape 'sphere)(* sphereConst r r))
			     ((equal? shape 'hexagon)(* hexagonConst r r))
			     (else (* r r))
))

#| a procedure call in Scheme first turns the argument expressions into their values before proceeding => applicative order
an alternative way of evaluating is when we call a procedure and take the argument expressions and substitute them into the procedure body. These expressions are not evaluated until a primitive is called. Thus a procedure can call a helper procedure that calls a helper procedure which calls a primitive say + and at that point, that is when the expressions are evaluated. => normative order
|#

#| generally the same answer is obtained whether applicative or normative order is used EXCEPT when the expressions do not return a constant value every time ie the expressions contain non-function expressions eg random() which is a procedure but not a function|#

#|functional programming protects you from having to think about what is going on and when it's going on inside of the computer. You have to be careful to stick to the strictly using functions that return consistent values for it to work. |#