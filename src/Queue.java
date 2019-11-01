public class Queue<E>{
    public Node<E> front;
    public Node<E> back;
    private int size;

    public void enqueue(E element){

        if(!isEmpty()) {
            Node<E> newNode = new Node(element);
            back.setBack(newNode);
            back = newNode;
            this.size++;
        } else {
            Node<E> newNode = new Node(element);
            front = newNode;
            back = newNode;
            this.size++;
        }

    }

    public E dequeue() throws Exception {
        if(this.size == 1){
            Node<E> oldFront = front;
            front = null;
            back = null;
            size--;
            return oldFront.getData();
        } else if(!isEmpty()){
            Node<E> newFront = front.getBack();
            Node<E> oldFront = front;
            front.setBack(null);
            front = newFront;
            this.size--;
            return oldFront.getData();
        } else{
            throw new Exception("Tried to dequeue an empty stack");
        }
    }

    public boolean isEmpty(){

        return this.size == 0 && this.front == null && this.back == null;

    }

    public int size(){
        return this.size;
    }

    public E peek() throws Exception {
        if(!isEmpty()) {
            return front.getData();
        } else {
            throw new Exception("Tried to peek at an empty stack");
        }
    }
}