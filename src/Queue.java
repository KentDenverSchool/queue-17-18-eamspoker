public class Queue<E>{
    private Node<E> front;
    private Node<E> back;
    private int size;

    public void enqueue(E element){

        if(!isEmpty()) {
            Node newNode = new Node(element);
            back.setBack(newNode);
            back = newNode;
            this.size++;
        } else {
            Node newNode = new Node(element);
            front = newNode;
            back = newNode;
            this.size++;
        }

    }

    public E dequeue(){
        return null;
    }

    public boolean isEmpty(){
        return this.size == 0 && this.front == null && this.back == null;
    }

    public int size(){
        return this.size;
    }

    public E peek(){
        return front.getData();
    }
}