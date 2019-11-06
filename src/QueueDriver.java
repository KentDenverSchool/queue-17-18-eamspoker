import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class QueueDriver {
    public static void main(String[] args)
            throws IOException{
        Scanner s = new Scanner(System.in);
        String results = "_________Queue Tests_________"+
                "\n\nTests in format expected: actual: passed:true/false\n\n";


        //Tests
        // in try catch blocks so even if the test errors
        // we always write a log!


        results += "Empty Constructor test: \n";
        //Empty Constructor Test
        try{
            //code we want to test


           Queue st = new Queue();
           results+= (st.size() == 0) + " Size should be: 0, Actual: " + st.size() +
                   "\n";


        } catch(Exception e){
            //what happens if code throws an error

           results+="ERROR: " + e + "\n";

        }

        //enqueue/size/isEmpty test
        results += "\nenqueue 2 elements, check both size and IsEmpty, peek to make sure values match: \n";

        try{
            //code we want to test
            Queue<String> enqueueQueue = new Queue<>();
            enqueueQueue.enqueue("element");


            //test size after enqueue
            results+= (enqueueQueue.size() == 1) + " Size should be: 1, Actual: " + enqueueQueue.size() +
                    "\n";

            //test isEmpty after enqueue
            results+= (!enqueueQueue.isEmpty()) + " IsEmpty should return false, Actual: " + enqueueQueue.isEmpty() +
                    "\n";

            //test peek returns enqueued element
            results += (enqueueQueue.peek().equals("element")) + " Peek should be: \"element\", Actual: "
                    + enqueueQueue.peek() + "\n";

            //add another element
            enqueueQueue.enqueue("element2");

            //test size after 2nd enqueue
            results+= (enqueueQueue.size() == 2) + " Size should be: 2, Actual: " + enqueueQueue.size() +
                    "\n";

            //test isEmpty after 2nd enqueue
            results+= (!enqueueQueue.isEmpty()) + " IsEmpty should return false, Actual: " + enqueueQueue.isEmpty() +
                    "\n";

            //test peek returns enqueued element
            results += (enqueueQueue.peek().equals("element")) + " Peek should be: \"element\", Actual: "
                    + enqueueQueue.peek() + "\n\n";

        } catch(Exception e){
            //what happens if code throws an error

            results+="ERROR: " + e + "\n";

        }


        //test peek/dequeue/size/isEmpty
        results += "\n\ndequeue 2 elements, check both size and IsEmpty, peek to make sure values match: \n";
        try{
            //code we want to test
            Queue<String> dequeueQueue = new Queue<>();
            dequeueQueue.enqueue("one");
            dequeueQueue.enqueue("two");
            String dequeued = dequeueQueue.dequeue();


            //dequeue one element, see if it returns
            results+= (dequeued.equals("one")) + " dequeued element should be: \"one\", Actual: " + dequeued +
                    "\n";

            //test size after dequeue
            results+= (dequeueQueue.size() == 1) + " Size should be: 1, Actual: " + dequeueQueue.size() +
                    "\n";

            //test isEmpty after dequeue
            results+= (!dequeueQueue.isEmpty()) + " IsEmpty should return false, Actual: " + dequeueQueue.isEmpty() +
                    "\n";

            //test peek returns enqueueed dequeue
            results += (dequeueQueue.peek().equals("two")) + " Peek should be: \"two\", Actual: "
                    + dequeueQueue.peek() +"\n";

            //remove another element
            dequeued = dequeueQueue.dequeue();


            //dequeue one element, see if it returns
            results+= (dequeued.equals("two")) + " dequeued element should be: \"two\", Actual: " + dequeued +
                    "\n";

            //test size after 2nd dequeue
            results+= (dequeueQueue.size() == 0) + " Size should be: 0, Actual: " + dequeueQueue.size() +
                    "\n";

            //test isEmpty after 2nd dequeue
            results+= (dequeueQueue.isEmpty()) + " IsEmpty should return true, Actual: " + dequeueQueue.isEmpty() +
                    "\n";
        } catch(Exception e){
            //what happens if code throws an error

            results+="ERROR: " + e + "\n";

        }

        results += "\n\nCatching empty Queue exceptions: \n";

        try{
            //code we want to test
            Queue<String> exceptionQueue = new Queue<>();
            exceptionQueue.enqueue("one");
            exceptionQueue.dequeue();

            //try to dequeue from an empty Queue
            exceptionQueue.dequeue();
            results += "ERROR: dequeued from an empty Queue\n";

        } catch(Exception e){
            //check if it's the right exception
                results += e.toString().equals("java.lang.Exception: Tried to dequeue an empty queue") + " ERROR: " +
                        e + "\n";
        }

        try{
            //code we want to test
            Queue<String> exceptionQueue = new Queue<>();

            //try to peek at an empty Queue
            exceptionQueue.peek();
            results += "ERROR: Peeked at an empty Queue\n";

        } catch(Exception e){
            //what happens if code throws an error
                results += e.toString().equals("java.lang.Exception: Tried to peek at an empty queue") + " ERROR: " +
                        e + "\n";

        }







        System.out.println("enter log name");
        BufferedWriter writer = new BufferedWriter(new FileWriter(s.nextLine()));
        writer.write(results);

        writer.close();
    }
}
