/* Queue.java
 * This class creates a queue where you can enqueue, dequeue, and peek elements. It has two instance data,
 * size, and front, and an accessor for size. Also has a method that returns whether or not the stack is empty.
 * Date: 11/06/19
 * On my honor: EA
 */
public class Queue<E>{
    public Node<E> front;
    public Node<E> back;
    private int size;

    //returns void, takes in an element and puts it at the back of the queue
    public void enqueue(E element){

        if(!isEmpty()){
            //point the back's pointer to the element, set the element as the back
            Node<E> newNode = new Node(element);
            back.setBack(newNode);
            back = newNode;
            this.size++;
        } else {
            //if it is the first element, then the element is both front and back
            Node<E> newNode = new Node(element);
            front = newNode;
            back = newNode;
            this.size++;
        }

    }

    //returns the item removed, no parameters, removes element at the top of the stack
    public E dequeue() throws Exception {
        if(this.size == 1){
            //if it is the last element, just set both back and front to null
            Node<E> oldFront = front;
            front = null;
            back = null;
            size--;
            return oldFront.getData();
        } else if(!isEmpty()){

            //set the old front to null, set front as the item behind it
            Node<E> newFront = front.getBack();
            Node<E> oldFront = front;
            front.setBack(null);
            front = newFront;
            this.size--;
            return oldFront.getData();
        } else {
            throw new Exception("Tried to dequeue an empty queue");
        }
    }

    //returns whether or not the queue is empty, no parameters
    public boolean isEmpty(){

        return this.size == 0 && this.front == null && this.back == null;

    }

    //returns the int size value, no parameters
    public int size(){
        return this.size;
    }

    //returns the data of the top element on the queue, no parameters
    public E peek() throws Exception {
        //conditional because it will throw an error if you try to use it in empty queue
        if(!isEmpty()){
            return front.getData();
        } else {
            throw new Exception("Tried to peek at an empty queue");
        }
    }
}