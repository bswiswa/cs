#|
Efficiency
How do we measure the efficiency in time of some algorith?
Cannot use the actual running time on a computer because that is not only affected by the algorithm but also the age of the computer and what other tasks the computer is running. 

Instead we look at the algorithm and count how many primitive constant time operations it does. Here you assume that say all arithmetic operations take constant time (not quit true eg factorial of a large number added to another number).
|#

(define (square x) (* x x))

(define (squares nums)
  (if (empty? nums)
      '()
      (se (square (first nums))
	  (squares (bf nums))) ))

#| you can count the number of primitive operations in squares:
1. empty?
2. if
3. first
4. square = (* x x)
5. bf
6. se

For each variable squares is called once so for N variables, the time is approx ~ 6N
|#

(define (sort sent)
  (if (empty? sent)
      '()
      (insert (first sent)
	      (sort (bf sent))) ))

(define (insert num sent)
  (cond ((empty? sent) (se num))
	((< num (first sent)) (se num sent))
	(else (se (first sent) (insert num (bf sent)))) ))
#| here sort is using an insertion sort helper function. This is where we insert into an already sorted hand. |#
#| when trying to estimate the run time, assume the worst case. You could also assume that the number we want to search is in the middle. It is easier and more helpful though to assume the worst case |#

(define (sortmax x) (
		  if(empty? x) '()
		    (filterByMax (first x) (sortmax(bf x)))))

(define (filterByMax x y)(
			  cond((empty? y) (se x))
			          ((> x (first y)) (se x y))
				       (else (se (first y) (filterByMax x (bf y)))) ))

#| Big O - ignore the constants and focus on the exponents of the steps 
some common families of time constraints are as follows:
Theta(1), Theta(log N), Theta(N) ==> Searching
Theta(N log N), Theta(N^2) ==> Sorting
Theta(N^3) ==> Matrix multiplication
Theta(2^N), Theta(N!), Theta(N^N) ==> Intractible (for practical data sets these programs would take way too long to run). Cannot be done in practice. For problems like this, you attempt to come up with an approximation
