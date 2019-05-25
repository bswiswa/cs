#| Hierarchical data structures
Represent hierarchies.
Trees
- unlike Lists, there is nothing built into Scheme about them. They are an abstract data type. This is because we will want different kinds of trees for different purposes eg representing hierarchies, creating efficient search mechanisms

Binary Search Tree
 - is a binary tree because each node has at most 2 children. 
 - is a binary search tree because the left child node is less than the parent node and the right child node is larger than the parent node. Position of the elements is arbitrary as long as it comes out well balanced.
 - allows us to order in an efficient way
 - The value of a binary search tree is its efficient search. Searching in tree takes Theta(log N)
- a binary search tree is not necessarily used to represent a hierarchy but to allow ordering in an efficient way.

Parse Tree
 - can be used to represent expressions eg 3 + (4 * 5)
 - there are many ways to traverse a tree eg in-order-traversal (left - middle - right), prefix-first and lastly post-fix.(reverse polish notation)
 - compilers and interpreters build this structure in order to process inputs

Node
- is a piece of a tree. A tree happens to be a node that we happen to be considering
- it is important to remember this because most data structure textbooks treat trees and nodes as different things and as a result they build way to complicated abstract data types and as a result of that their programs are large and people end up just thinking that trees are difficult to work with. By considering trees and nodes as synonyms, you can inoculate yourself against the fear of trees.

Trees version 1
 Create a tree that can have any number of nodes
 For this kind of tree it is best to set the rule that no empty tree can be defined 

 **When creating abstract data types, it is helpful to create meaningful synonyms that you can use to make the program readable. Once the abstract data type is created correctly, you do not have to think about the underlying structure and syntax any more.
|#

(define make-tree cons)
(define datum car)
(define children cdr)

(define (leaf? node)
  (null? (children node)) )

(define (leaves . seq)
  (map (lambda (x) (make-tree x '())) seq) )

#| To create a tree like this:
                     1
           2                  5
       3      4            6  7  8
|#
(define t1
  (make-tree 1
	     (list (make-tree 2 (leaves 3 4))
		   (make-tree 5 (leaves 6 7 8)) )))
#| above children are a list of trees => called a forest
 We can write a map function for trees that uses mutual recursion as shown below (treemap calls map and map calls treemap). This function has two base cases: a vertical one which is when a node is a leaf and a horizontal one which is when map reaches the end of the list of children. This algorithm is very powerful an everything is handled in the background and it illustrates the power of mutual recursion in a 2 dimensional data structure. Here the horizontal traversal is handled by map and the vertical traversal is handled by the children function.
It could have been written iteratively but this is actually a more complicated method that takiing advantage of mutual recursion, especially given the increased memory in modern computers.
|#
(define (treemap fn tree)
  (make-tree (fn (datum tree))
	     (map (lambda (child) (treemap fn child)) (children tree)) ))

#| Deep List
- eg a list of sentences
((the quick)(brown fox)(jumped over)(the lazy)(dog))

Could be represented by a tree as follows:
                             0
   0               0            0          0         0
the quick     brown fox   jumped over   the lazy    dog

This is a funny sort of tree because the branch nodes don't have data. So there is a sharp distinction between a leaf node which has datum but no children and the branch nodes which have children but no datum.
It is a tree-like structure and we can use tree-like code to manipulate this list of lists:
|#

(define (deepmap fn lol)
  (if (list? lol)
      (map (lambda (element) (deepmap fn element)) lol)
  (fn lol)))

(define lol '((the quick) (brown fox) (jumped over) (the lazy) (dog)))