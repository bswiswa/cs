#| Procedures as data is powerful -> you can create a language consisting of lambda (the procedure generators) and the ability to call procedures and this language can be universal. You can make arithmetic using lambdas and procedures eg you can write procedures in scheme without using the define statement
Lots of times you have a  problem where you want to do some filtering of data. That pattern is captured by a higher order function. Then all the actual filtering can be specified for each instance in a lambda

First class data types
A data type is first class in a language if things of that type can be the value of a variable. Can be an argument to a procedure.Can be the value returned by a procedure. Can be a member of an aggregate eg an array. Can be anonymous
In every language, numbers are first class. Character strings in most languages (not in C). Data aggregates are rarely first class. Some languages give pointers to the aggregates and those are first class.
Lambdas are a key central idea of Lisp and they are being adopted in many languages now eg Java

Why is there more than one programming language?
- different languages have different design principles. One of the design principles of Scheme is "everything first class" that is, if it is in the language at all, it should be manipulable in the ways outlined before:
CAN BE:
- the value of a variable
- an argument to a procedure
- the value returned by a procedure
- a member of an aggregate
- anonymous

Most other languages use the design principle that everything should be very efficiently compilable.

Some languages use the principle that everything should look "natural"
Scheme's design principle is that if a data type is in the language, it should be first class or "everything first-class"
|#

; a procedure can return a procedure eg
(define (make-adder num)
  (lambda(x) (+ x num)))
#| here the domain (what it can take) of make-adder is numbers and the range(what it can produce) of make-adder is procedures. It returns a procedure with a domain of numbers and a range of numbers as well.
One can now go on to create procedurecs from make-adder as follows:
|#
(define plus3 (make-adder 3))

; now plus3 can be used as a procedure on other numbers eg (plus3 8) = 11
#| you can even define a procedure that returns a lambda function that takes other functions as arguments eg:|#
(define (compose f g) (lambda(x) (f (g x))))
; then you can make a call ((compose first bf) '(programming is fun)) => is
; in order for compose to work, the domain of f has to include the range of g

#|one can create a function that calculates the roots of a quadratic equation ax + bx + c = 0 as follows |#
(define (roots a b c)
  (se (/ (+ (- b) (sqrt (- (* b b) (* 4 a c)))) (* 2 a))
          (/ (- (- b) (sqrt (- (* b b) (* 4 a c)))) (* 2 a))))
#|however the problem here is that there is redundant typing and it is a little hard to read. This can be improved slightly by using a helper function|#
(define (broots a b c)
  (define (broots1 discriminant)
    (se (/ (+ (- b) discriminant) (* 2 a ))
	    (/ (- (- b) discriminant) (* 2 a))) )
  (broots1 (sqrt (- (* b b) (* 4 a c)))) )
#| however even with the helper function, the problem is that the definition of the discriminant is separated from its actual use. An anonymous lambda function can be used to improve further on this as follows: |#
(define (croots a b c)
  ((lambda(discriminant) 
    (se (/ (+ (- b) discriminant) (* 2 a))
	(/ (- (- b) discriminant) (* 2 a)))) (sqrt(- (* b b) (* 4 a c)))))

#|even though the above solution may be elegent in some sense, it is ugly to read and can be improved upon|#

#| let syntax
(let bindings body)
bindings = (binding binding binding...)
binding = (name value-expression)
|#
(define (droots a b c)
  (let ((discriminant (sqrt(- (* b b) (* 4 a c)))))
    (se (/ (+ (- b) discriminant) (* 2 a))
	(/ (- (- b) discriminant) (* 2 a)) )))
#| this can further be optimized albeit in a way that has invalid Scheme variable names (STk is forgiving) |#
(define (eroots a b c)
  (let ((discriminant (sqrt(- (* b b) (* 4 a c))))
	(-b (- b))
	(2a (* 2 a)))
    (se (/ (+ -b discriminant) 2a)
	(/ (- -b discriminant) 2a)) ))
#| when using let, you cannot have one variable depending on another due to the applicative order rule. For example if the variable -b depended on the discriminant value in its declaration, it would fail because when in applicative order it would try to evaluate discriminant when it doesn't exist yet. There is another form of let which allows you to do this however and it is called let* . It does this by nesting the let calls|#
#| Another way to think  of this is that let defines the variables in parallel and so one variable cannot be seen by another at the time of declaration |#

#| let is not like assignment statements. All the variables defined in a let are only accessible inside its body|#

#|The ability to use procedures as data lets us build any control mechanism we want.|#
