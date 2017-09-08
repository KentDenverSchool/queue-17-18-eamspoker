# Writing a Queue

Recall that a queue is a first in, first out data structure. This means that the most recently added element is last in the queue. A queue must have the following methods:
```java

void enqueue(E element)    //add an element
E dequeue()                //remove and return the least recent element
boolean isEmpty()   
int size()

//not required, but common
E peek()                //look at the least recent element without removing

```


### Your Assignment

Complete the class `Queue.java`. You may only use one Node pointer (e.g. first or last). You should not have to use any for loops or other O(n) algorithms for these methods. All methods should be worst case O(1). Test that it works by writing a driver.
