#| we could define a function that calculates the total number of points based on cards that are in someone's hand. Say if the person has a 3 of hearts, 10 of diamonds and a 5 of spades we would call (total-hand '(3h 10d 5s)) |#
(define (total-hand hand)
  ( if(empty? hand)
      0
      (+ (butlast (last hand)) (total-hand (butlast hand)) )))

#| the trouble with this function is that there are two calls to butlast that mean completely different things. This makes the program a bit harder to read especially if you consider that in real life this function would be one of a thousand other functions in a program. 
Another case to consider is if you decide to change the direction in which the hand is red, say from left to right rather than from right to left above. This would mean having to change one of the calls to butlast (the second one) to butfirst and keeping the other one.
We can improve the readability of the program above by defining some synonyms for last and butlast |#

(define (total-hand hand)
  (if (empty? hand)
      0
      (+ (card-rank (one-card hand)) (total-hand (remaining-cards hand)) )))

(define card-rank butlast)
(define one-card last)
(define remaining-cards butlast)

#| this change above to using some synonyms makes the code more readable and more maintainable |#
#| Also note that Scheme knows about data types like numbers, words and sentences but a data type like a card hand is something that the programmer knows and has used words and sentences to represent it. If one wishes to change one card in the hand, you would have to redefine the hand again with that single change. An alternative way is to use constructors |#
(define (make-card rank suit)
  (word rank (first suit)))

(define make-hand sentence)

#| so now we can make a call to our total-hand function using the make-hand constructor :
(total-hand (make-hand (make-card 2 'spades) (make-card 10 'diamond) ))

Even though there is now more typing, there is actually better representation/readability and we can change how we want to construct the cards and the program would still work
|#


#| we could decide to change the make-card function to return numbers between 0 and 51,
that is say spades 0 - 12, hearts 13-25, diamond 26-38, clubs 39-51 |#
(define (make-card rank suit)
  (cond((equal? suit 'spades) rank)
       ((equal? suit 'hearts) (+ rank 13))
       ((equal? suit 'diamond) (+ rank 26))
       ((equal? suit 'clubs) (+ rank 39))
       (else (error 'say what?)) ))
; we'd have to redefine card-rank as well so that it produces a number
(define (card-rank card)
  (remainder card 13) )

#| We are still able to make a call to total-hand and get the correct answer even without changing anything in the definition of the total-hand function itself.
(total-hand (make-hand (make-card 3 'hearts) (make-card 10 'clubs) (make-card 4 'diamond))) --> 17
The point here is that we can change the representation of a data type by changing its constructor and as long as we consistently use its selectors we do not have to change every instance of where the data type is used
 |#

#|Every programming language has a way of building data structures out of pieces. In Scheme the main data aggregation method is made up of Lists. Lists are made up of pairs eg
-> 3 | 4 which could represent the fraction 3/4
The constructor for pairs is called CONS (construct). The two selectors are called CAR and CDR. The reason these names are still in use is because we can build data structures by connecting these together is because it can be used as a short hand for navigating a data structure.
|#

#|we can define a constructor for a pair(the constructor returns the pair as a function) as follows:
|#
(define (cons x y)
  (lambda(which)
    (cond ((equal? which 'car) x)
	  ((equal? which 'cdr) y)
	  (else (error "Bad message to CONS" which) ))))
; and the selectors
(define (car pair)
  (pair 'car))

(define (cdr pair)
  (pair 'cdr))

#| The main way that pairs are used is as a List. A list is an abstraction eg a sequence of n elements where each element is a pair. The CAR of each pair is an element of the sequence and the CDR of the pair is the next pair along except for the last element whose CDR is an empty list
|#
#|
CAR|CDR -> CAR|CDR -> CAR|CDR -> CAR|X

Lists are half-abstract. A sentence is a list in which the elements are constrained to only be words.

(cons 3 4) -> (3 . 4) => this is list of one element with CAR = 3, CDR = 4
(cons 3 (cons 4 (cons 5 '()))) -> (3 4 5) => this is a list of 3 elements. So the above is a shorthand for writing pairs that are hooked together 
|#

#|
(cons '(3 4) '(5 6)) -> ((3 4) 5 6) => a list of 3 elements, the first of which is a list. The CAR of a pair is one element even if itself is a list. |#

#| 
Another constructor for lists is the list function which takes a number of elements and returns a list in which each element of the list is one of the argument. |# 
#|
(list 3 4 5 6) -> (3 4 5 6)
cons takes the first argument as an element, the second argument is an already existing list.

Another constructor is called append and it makes a list of the elements of the arguments. So it can be given lists as arguments and it will make a list of the elements themselves eg (append '(3 4) '(5 6)) -> (3 4 5 6)
|#

#|
list is only good if you know how many arguments you are going to specify. Usually you won't know so list is the least useful. 
append is mostly useful but the most useful is cons as it can be used iteratively.

Why were sentences made then if lists provide the functionality? This is because sentences are easier to work with as you learn without having to think about the representation as well.
|#

#| lists can hold anything and they do not have to be homogenous. They can have numbers, words, lists, and procedures.
|#




