#| Higher order functions for list 
every -> computes a function of each element of a word or sentence and puts them together
keep -> takes a word or sentence and returns a subset
accumulate -> takes a combiner function that takes two things and puts them together
map -> the list equivalent of every. It computes a function of each element of a list and puts them together
filter -> takes a list and returns a subset list
eg 
(map first '((john lennon) (paul mccartney) (george harrison)))
-> (john paul george)
(filter (lambda(x)(equal? x 'john)) (list 'john 'john 'batsi))
-> (john john)

Difference between a list and a sentence
|#
(define (reverse sent)
  (if (empty? sent)
      '()
      (se (last sent) (reverse (bl sent))) ))
#|
(reverse '(the quick brown fox jumps over the lazy dog))
-> (dog lazy the over jumps fox brown quick the)

Another way to reverse the sentence is
|#
(define (reverse2 sent)
  (if(empty? sent)
     '()
     (se (reverse2(butfirst sent)) (first sent)) ))
#| if we try to do the same for a list it fails |#
(define (reverse-list-attempt seq)
  (if(null? seq)
     '()
     (cons (reverse-list-attempt (cdr seq)) (car seq)) ))
; -> ((((() . d) . c) . b) . a)
#| this is what happens when cons is called with something other than a list as the second argument. cons is very good when you want to stick an element at the start of a list but doesn't work when you want to add a new element at the end of a list. This is because of the asymetry in the spine of a list that in each pair the CAR is an element and the CDR is another pair. 
The most straight-forward way is as follows - using append instead:
|#

(define (reverse-list seq)
  (if(null? seq)
     '()
     (append(reverse-list (cdr seq)) (list (car seq))) ))

; apply function can be used to run a procedure on a result from another function
(map bf '((Chrome wont) (save the) (following information)))
; -> ((wont) (the) (information)
#| which is a list of sentences (list of words). If we wished to have one list as a result and not a list of lists, we could apply the append function |#
(apply append (map bf '((Chrome wont) (save the) (following information))))
; -> (wont the information)
